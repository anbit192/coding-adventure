import time

def do_something():
    print("sleeping 1 second...")
    time.sleep(1)
    print("Done sleeping...")

def main():
    start = time.perf_counter()


    do_something()
    do_something()

    end = time.perf_counter()

    duration = round(end - start, 2)
    print(f"total time: {duration} seconds")

if __name__ == "__main__":
    main()