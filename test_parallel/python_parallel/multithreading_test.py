import time
import threading


def do_something(seconds=1):
    print(f"sleeping {seconds} second...")
    time.sleep(seconds)
    print("Done sleeping...")


def basic_example():  # running with 2 thread manually
    thread1 = threading.Thread(target=do_something)
    thread2 = threading.Thread(target=do_something)

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()


def create_threads():  # using for loop to create and start and join threads

    threads = []

    for _ in range(10):  # create 10 threads
        t = threading.Thread(target=do_something)
        t.start()
        # t.join() if we join each thread here, it would be the same as running synchronious, so dont!
        # instead we add each of these thread to a list and join them all at once
        threads.append(t)

    for t in threads:
        t.join()


def thread_with_args():  # passing argument to function in threading
    threads = []

    for _ in range(10):  # create 10 threads
        # pass 3 second as the args (the parameter args take an iterable type!)
        t = threading.Thread(target=do_something, args=[3])
        t.start()
        # t.join() if we join each thread here, it would be the same as running synchronious, so dont!
        # instead we add each of these thread to a list and join them all at once
        threads.append(t)

    for t in threads:
        t.join()


def main():

    print("=====================1======================")

    # 1.
    # run this normally would took 2 seconds:
    start = time.perf_counter()

    do_something()
    do_something()
    end = time.perf_counter()

    duration = round(end - start, 5)
    print(f"total time: {duration} seconds")

    print("=====================2======================")

    # 2.
    # with thread: about 1 second
    start = time.perf_counter()

    basic_example()
    end = time.perf_counter()

    duration = round(end - start, 5)
    print(f"total time: {duration} seconds")

    print("=====================3======================")

    # 3.
    # the same with this!
    start = time.perf_counter()

    create_threads()
    end = time.perf_counter()

    duration = round(end - start, 5)
    print(f"total time: {duration} seconds")
    print("=====================4======================")

    # 4.
    start = time.perf_counter()

    thread_with_args()

    end = time.perf_counter()

    duration = round(end - start, 5)
    print(f"total time: {duration} seconds")


if __name__ == "__main__":
    main()
