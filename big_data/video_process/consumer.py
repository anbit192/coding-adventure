import cv2
from kafka import KafkaProducer, KafkaConsumer
import numpy as np
import multiprocessing
import threading
import queue

def consume_video_from_kafka(consumer, topic, frame_queue):
    for msg in consumer:
        frame_data = np.frombuffer(msg.value, dtype=np.uint8)
        frame = cv2.imdecode(frame_data, cv2.IMREAD_COLOR)
        frame_queue.put((topic, frame))

def update_gui(frame_queue):
    while True:
        try:
            topic, frame = frame_queue.get(timeout=1)
            cv2.namedWindow(topic, cv2.WINDOW_NORMAL)
            cv2.imshow(topic, frame)
            if cv2.waitKey(1) & 0xFF == ord("q"):
                break
        except queue.Empty:
            pass

def main():
    topic1 = "topicA"
    topic2 = "topicB"

    frame_queue = multiprocessing.Queue()

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
        api_version=(0, 10)
    )

    consumer_t1 = multiprocessing.Process(target=consume_video_from_kafka,
                                          args=(consumer1, topic1, frame_queue))
    
    consumer_t2 = multiprocessing.Process(target=consume_video_from_kafka,
                                          args=(consumer2, topic2, frame_queue))

    gui_thread = threading.Thread(target=update_gui, args=(frame_queue,))

    consumer_t1.start()
    consumer_t2.start()
    gui_thread.start()

    consumer_t1.join()
    consumer_t2.join()
    gui_thread.join()

if __name__ == "__main__":
    main()
