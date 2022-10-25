import matplotlib.pyplot as plt
import numpy as np
from matplotlib import projections
from mpl_toolkits.mplot3d import Axes3D


def f(x, y):
    upperbound = np.sqrt(1-x**2)
    lowerbound = (1-np.sqrt(x))**2

    return np.where((y<upperbound) & (y>lowerbound), x+y,None)



x = np.linspace(0,1,100)
y = np.linspace(0,1,100)

X, Y = np.meshgrid(x, y)
Z = f(X, Y)

figure = plt.figure()
ax1 = plt.axes(projection='3d')

ax1.plot_surface(X, Y, Z)
plt.show()
