import cv2
from kafka import KafkaProducer
import threading


def publish_video_to_kafka(producer, topic, video_path):

    cap = cv2.VideoCapture(video_path)
    while (cap.isOpened()):
        ret, frame = cap.read()
        if not ret:
            break

        _, buffer = cv2.imencode(".jpg", frame)
        data = buffer.tobytes()

        producer.send(topic=topic, value=data)

    cap.release()


def main():
    # configure kafka producer
    # bootstrap_server = "localhost:9092"
    producer = KafkaProducer(
        bootstrap_servers=["localhost:9092"],
        api_version=(0, 10, 1)
    )

    # Create and run producer for topic 1 in a separate thread
    topic1 = "topicA"
    video_path1 = "video_process/roads.mp4"
    prod_thread1 = threading.Thread(target=publish_video_to_kafka,
                                    args=(producer, topic1, video_path1))

    # Create and run producer for topic 2 in a separate thread
    topic2 = "topicB"
    video_path2 = "video_process/roads.mp4"
    prod_thread2 = threading.Thread(target=publish_video_to_kafka,
                                    args=(producer, topic2, video_path2))
    
    prod_thread1.start()
    prod_thread2.start()

    prod_thread1.join()
    prod_thread2.join()


if __name__ == "__main__":
    main()
