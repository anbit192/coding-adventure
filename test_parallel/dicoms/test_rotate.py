import os
import matplotlib.pyplot as plt
import numpy as np
import cv2
import pydicom as dicom
import math

# Create a test image
img = dicom.dcmread("dicoms/PAT034/D0001.dcm").pixel_array
plt.imshow(img)
plt.show()

# Rotation angle in degrees
rotation_angle = 45

# Calculate the new image dimensions
angle_r = math.radians(rotation_angle)  # Convert to radians
h, w = img.shape

# Calculate the coordinates of the four corners of the rotated image
# cos_theta = abs(math.cos(angle_r))
# sin_theta = abs(math.sin(angle_r))
new_w = int(math.sqrt(w**2 + h**2))
new_h = new_w

# Calculate the rotation matrix
rotation_matrix = cv2.getRotationMatrix2D((w/2, h/2), rotation_angle, scale=1)

# Warp the image
rotated_img = cv2.warpAffine(img, rotation_matrix, (new_w, new_h))

cv2.imwrite("Rotated_test.png", rotated_img)
plt.imshow(rotated_img)
plt.show()