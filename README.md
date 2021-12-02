## Algorithms

### The main task is to realize Bellman-Ford algorithm.
Given a graph and a source vertex src in graph, find shortest paths from src to all vertices in the given graph.</br> 
The graph may contain negative weight edges. Like Dijkstra's algorithm, Bellman–Ford proceeds by relaxation,</br>
in which approximations to the correct distance are replaced by better ones until they eventually reach the solution.</br>
 In both algorithms, the approximate distance to each vertex is always an overestimate of the true distance,</br>
 and is replaced by the minimum of its old value and the length of a newly found path.</br>
