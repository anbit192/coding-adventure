import multiprocessing
import time
import numpy as np
from numba import njit, prange

m, n, c = 1000, 1500, 1200
A = np.random.randint(1, 50, size = (m, n))
B = np.random.randint(1, 50, size = (n, c))



start = time.perf_counter()

@njit(parallel=True)
def mult_mat(matrixA, matrixB):

    result = np.zeros((matrixA.shape[0], matrixB.shape[1]),)

    for i in prange(matrixA.shape[0]):
        for k in range(matrixA.shape[1]):
            for j in range(matrixB.shape[1]):
                result[i, j] += matrixA[i, k] * matrixB[k, j]

    return result

res = mult_mat(A, B)

# res = A @ B

end = time.perf_counter()

print(res)
print(f"total: {end-start}")




