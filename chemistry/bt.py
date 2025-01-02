import random
import numpy as np
from deap import base, creator, tools, algorithms
import math

def target_func(candidate):
    x, y = candidate
    return math.exp((x - 7) * 2 + (y - 9) * 2),

creator.create("OptFitness", base.Fitness, weights=(-1.0,))
creator.create("Entity", list, fitness=creator.OptFitness)

toolbox = base.Toolbox()
toolbox.register("random_value", random.uniform, -10, 10)
toolbox.register("create_entity", tools.initRepeat, creator.Entity, toolbox.random_value, 2)
toolbox.register("create_population", tools.initRepeat, list, toolbox.create_entity)

toolbox.register("evaluate", target_func)
toolbox.register("cross", tools.cxBlend, alpha=0.5)
toolbox.register("mutate", tools.mutGaussian, mu=0, sigma=1, indpb=0.2)
toolbox.register("select", tools.selTournament, tournsize=3)

POP = 100
GEN = 50
CX_RATE = 0.7
MUT_RATE = 0.2

def ga_no_elitism():
    pop = toolbox.create_population(n=POP)
    algorithms.eaSimple(pop, toolbox, cxpb=CX_RATE, mutpb=MUT_RATE, ngen=GEN, verbose=True)
    top_entity = tools.selBest(pop, k=1)[0]
    return top_entity, top_entity.fitness.values[0]

def ga_with_elitism():
    pop = toolbox.create_population(n=POP)
    algorithms.eaMuPlusLambda(pop, toolbox, mu=POP, lambda_=POP, cxpb=CX_RATE, mutpb=MUT_RATE, ngen=GEN, verbose=True)
    top_entity = tools.selBest(pop, k=1)[0]
    return top_entity, top_entity.fitness.values[0]

result_no_elitism, value_no_elitism = ga_no_elitism()
print("Without elitism:")
print("Best candidate:", result_no_elitism)
print("Minimum value:", value_no_elitism)

result_with_elitism, value_with_elitism = ga_with_elitism()
print("\nWith elitism:")
print("Best candidate:", result_with_elitism)
print("Minimum value:", value_with_elitism)
