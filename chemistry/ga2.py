import numpy as np
from Bio.PDB import PDBParser
from pathlib import Path

def load_structure(file_path):
    parser = PDBParser(QUIET=True)
    return parser.get_structure("Protein", file_path)

def extract_coordinates(structure):
    coords = []
    for atom in structure.get_atoms():
        coords.append(atom.coord)
    return np.array(coords)

def define_bounds(coords, padding=4.5):
    min_vals = np.min(coords, axis=0)
    max_vals = np.max(coords, axis=0)
    min_vals -= padding
    max_vals += padding
    return min_vals, max_vals

def generate_box_vertices(min_vals, max_vals):
    x_min, y_min, z_min = min_vals
    x_max, y_max, z_max = max_vals
    vertices = [
        (x_min, y_min, z_min),
        (x_min, y_min, z_max),
        (x_min, y_max, z_min),
        (x_min, y_max, z_max),
        (x_max, y_min, z_min),
        (x_max, y_min, z_max),
        (x_max, y_max, z_min),
        (x_max, y_max, z_max)
    ]
    return vertices


pdb_file = Path.cwd() / "1VQQadd.pdb"
structure = load_structure(pdb_file)
atom_coords = extract_coordinates(structure)
min_bounds, max_bounds = define_bounds(atom_coords, padding=4.5)
box_vertices = generate_box_vertices(min_bounds, max_bounds)

print("Vertices of the bounding box:")
for vertex in box_vertices:
    print(vertex)
