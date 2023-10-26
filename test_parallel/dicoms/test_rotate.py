import os
import matplotlib.pyplot as plt
import numpy as np
import cv2

path = "./JPG_IMG/D0001.dcm.jpg"
img = plt.imread(path)

rotation_angle = 45

(w, h) = img.shape

rotation_matrix = cv2.getRotationMatrix2D((w/2, h/2), rotation_angle, scale=1)

rotated_img = cv2.warpAffine(img, rotation_matrix, img.shape)



cv2.imwrite("Rotated_test.png", rotated_img)


