import cv2
from kafka import KafkaProducer, KafkaConsumer
import numpy as np
import threading


# consume data sent from topic A and display the video
def consume_video_from_kafka1(consumer, topic):
    for msg in consumer:
        frame_data = np.frombuffer(msg.value, dtype=np.uint8)
        frame = cv2.imdecode(frame_data, cv2.IMREAD_COLOR)

        cv2.imshow(topic, frame)
        if (cv2.waitKey(1) & 0xFF == ord("q")):
            break


# consume data sent from topic B and display the video
def consume_video_from_kafka2(consumer, topic):
    last_gray = None

    for msg in consumer:
        frame_data = np.frombuffer(msg.value, dtype=np.uint8)
        frame = cv2.imdecode(frame_data, cv2.IMREAD_COLOR)
        gray_frame = cv2.GaussianBlur(frame, (5, 5), 0)

        if (last_gray is None):
            last_gray = gray_frame
            continue

        diff = cv2.absdiff(gray_frame, last_gray)

        _, difference = cv2.threshold(diff, 25, 255, cv2.THRESH_BINARY)

        last_gray = gray_frame

        cv2.imshow(topic, difference)
        if (cv2.waitKey(1) & 0xFF == ord("q")):
            break


def main():
    topic1 = "topicA"
    topic2 = "topicB"

    # create consumer for topic 1
    consumer1 = KafkaConsumer(
        topic1, 
        bootstrap_servers=["localhost:9092"],
        api_version=(0, 10)
    )

    # create consumer for topic 2
    consumer2 = KafkaConsumer(
        topic2,
        bootstrap_servers=["localhost:9092"],
        api_version=(0,10)
    )

    consumer_t1 = threading.Thread(target=consume_video_from_kafka1,
                                   args=(consumer1, topic1))
    
    consumer_t2 = threading.Thread(target=consume_video_from_kafka2,
                                   args=(consumer2, topic2))
    
    consumer_t1.start()
    consumer_t2.start()
    consumer_t1.join()
    consumer_t2.join()

if __name__ == "__main__":
    main()
