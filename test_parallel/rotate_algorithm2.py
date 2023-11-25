import numpy as np
from matplotlib import pyplot as plt
import pydicom as dicom

image = dicom.dcmread("./dicoms/PAT034/D0001.dcm").pixel_array
# image = np.ones((15, 20)) * 150
# image[0:5] = 50
img_transformed = np.zeros((image.shape), dtype=np.uint8)

c, s = np.cos(np.radians(45)), np.sin(np.radians(45))
rot_matrix = np.array([[c, s, 0], [-s, c, 0], [0, 0, 1]])

x, y = np.array(image.shape) // 2
# move center to (0, 0)
translate1 = np.array([[1, 0, -x], [0, 1, -y], [0, 0, 1]])
# move center back to (x, y)
translate2 = np.array([[1, 0, x], [0, 1, y], [0, 0, 1]])

# compose all three transformations together
trans_matrix = translate2 @ rot_matrix @ translate1

for i, row in enumerate(image):
    for j,col in enumerate(row):
        pixel_data = image[i,j] #get the value of pixel at corresponding location
        input_coord = np.array([i, j, 1]) #this will be my [x,y] matrix
        result = trans_matrix @ input_coord 
        i_out, j_out, _ = result #store the resulting coordinate location

        #make sure the the i and j values remain within the index range
        if (0 < int(i_out) < image.shape[0]) and (0 < int(j_out) < image.shape[1]):
            img_transformed[int(i_out)][int(j_out)] = pixel_data

inverse_tform = np.linalg.inv(trans_matrix)

for i, j in np.ndindex(img_transformed.shape):
    i_orig, j_orig, _ = np.round(inverse_tform @ [i, j, 1]).astype(int)
    if i_orig in range(image.shape[0]) and j_orig in range(image.shape[1]):
        img_transformed[i, j] = image[i_orig, j_orig]

plt.imshow(img_transformed, cmap='gray')
plt.show()