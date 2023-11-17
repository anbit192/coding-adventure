import concurrent.futures
import time

def do_something(seconds):
    print(f"sleeping {seconds} second...")
    time.sleep(seconds)
    return f"Done sleeping for {seconds} second..."

def main():
    start = time.perf_counter()

    with concurrent.futures.ThreadPoolExecutor() as executor:

        seconds = [5,4,3,2,1]

        # long way of writing this:
        # results = [executor.submit(do_something, sec) for sec in seconds]
        # for f in concurrent.futures.as_completed(results):
        #     print(f.result())


        # short way:
        results = executor.map(do_something, seconds)
        for result in results:
            print(result)

        # executor.submit() start the thread and return the value of function assigned to that thread so the order of return value is not maintained
        # executor.map() instead maintain the order of return value


    end = time.perf_counter()

    duration = round(end - start, 2)
    print(f"total time: {duration} seconds")

if __name__ == "__main__":
    main()