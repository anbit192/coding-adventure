from mpl_toolkits.mplot3d import axes3d
import matplotlib.pyplot as plt
import numpy as np

X, Y = np.meshgrid(np.linspace(2,0,10),np.linspace(0,2,10))

U = X*Y
V = (X**2)*(Y**2)

plt.quiver(X,Y,U,V,color='pink',angles='xy', scale_units = 'xy', scale = 1.5)
plt.arrow(2,0,-2,2,color='purple',shape='full',length_includes_head=True,head_width = .05,head_starts_at_zero = True)

plt.grid()
plt.show()