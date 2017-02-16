# COMPOSITEGRAPHER

## About

This is the source code and some sample matrices for the COMPOSITEGRAPHER software.

The COMPOSITERAPHER software generates networks containing: identical, inclusion, overlap and disjoint links between character-states.

## Usage

COMPOSITERAPHER is a graphical tool (GUI) programmed in Java. 

1. First obtain a [binary release](#binary-releases) or [compile](#Compilation) your own version.
2. Extract the zipped archive into a new directory
3. Run the COMPOSITEGRAPHER software:

A) Double-click on the COMPOSITEGRAPHER.jar from the main directory

B) Alternatively, you can start the software from the command-line with some minimum and maximum memory requirements.  

```
java -Xms=2g -Xmx=4g -jar COMPOSITEGRAPHER.jar
```
C) To perform several permuation (higher than 1000) for the estimation of the _p_-value, it is recommended to run the analysis from the command-line. 

For example for the matrix sample_5.txt located in the _sample_ directory  
With the **2000** permutations (-perm=1000)  and **100** concurrent threads (-maxpool=100)
```
java -jar COMPOSITEGRAPHER.jar sample/sample_5.txt -perm=2000 -maxpool=100
```
Full command-line options are:   

|             Options   | Usages                                         |
| -------------------- | ---------------------------------------------- |
|	-perm=100      | Specify the number permutation to performed.  |
|	-maxpool=10    | Specify the number of concurrent threads.|
|	-output=dir    | Specify output directory.|
|	-undefined     | Remove column containing undefined states (e.g. ?,-,\*)|
|	-multiple      | Remove column containing polymorphic states (e.g. {1,2,3}).|
|	-bipartite     | Output bipartite network files.|
|	-graphml       | Output graphml network files (Gephi, Cytoscape compatibles).|
|	-nodeid=file   | Provide a node identification file when importing the matrix.|
|	-variation=X   | Specify the variation string to use if polymorphic states are presents.|
| -triplets      | Output triplets file (triplets.txt) |

Generated results files are:  
|             Files    | Informations                                   |
| -------------------- | ---------------------------------------------- |
|	matrixfile_complete.txt               | edge list of the complete network. |
|	matrixfile_1.txt                      : edge list of the type 1 connections.|
|	matrixfile_2.txt                      : edge list of the type 2 connections.|
|	matrixfile_3.txt                      : edge list of the type 3 connections.|
|	matrixfile_4.txt                      : edge list of the type 4 connections.|
|	matrixfile_id.txt                     : identification for each node.|
|	matrixfile_summary.txt                : statistics and parameters for this run. |
|	matrixfile_summary_statistics.csv     : nodes statistics. |
|	log.txt                               : logfile.  |
|	reference.json                        : Serialized results for original dataset.|
|	randomization_XX.json                 : Serialized results for one permuation.|
|	matrixfile_permutation_statistics.csv : network statistics and _p_-value. |
|	matrixfile_percent_triplet_type3.csv  : tyep 3 network triplets per nodes. |
|	matrixfile_out_degree2.csv            : outdegree in type 2 network.  |
|	matrixfile_in_degree2.csv             : indegree in type 2 network.   |
|	matrixfile_closeness_type3.csv        : closeness in type 3 network.  |
|	matrixfile_betweenness_type3.csv      : betweenness in type3 network. |

If the [-bipartite] option is use, the following files will also be produced:  

|             Files    | Informations                                   |
| -------------------- | ---------------------------------------------- |
|matrixfile.bipartite_complete.txt| bipartite network of the complete network.|
|	matrixfile.bipartite_1.txt      | bipartite network of the type 1. |
| matrixfile.bipartite_2.txt      | bipartite network of the type 2.|
| matrixfile.bipartite_3.txt      | bipartite network of the type 3.|
|	matrixfile.bipartite_XX_id.txt  | identification for each node|

If the [-graphml] option is used, the following files will also be produced:

|             Files    | Informations                                   |
| -------------------- | ---------------------------------------------- |
|	matrixfile_complete.graphml | complete network (type 1,2, and 3 edges)|
|	matrixfile_1.graphml | type 1 network |
|	matrixfile_2.graphml | type 2 network |
|	matrixfile_3.graphml | type 3 network |
|	matrixfile_4.graphml | type 4 network |

If the [-triplets] option is used, the following file will also be produced:
	
|             Files    | Informations                                   |
| -------------------- | ---------------------------------------------- |
| triplets.txt         | triplets found in type 3 network               |


### Requirements

COMPOSITEGRAPHER is compatible with Java SE5 (JDK 5) and later versions of Java. The latest
Java platform is available at
[Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

## Compilation

The source code is distributed as Netbeans project format. A compiled jar file is also available.

## Dependencies

COMPOSITEGRAPHER depends on the following library:

##### [SSJ](https://github.com/umontreal-simul/ssj)  
The SSJ library is used for BitVector calculations and for computing random uniform distribution.  
The`ssj.jar` archive (version 3.2.0) is included in the COMPOSITEGRAPHER distribution and it must be in the CLASSPATH environment variable.

##### [Apache Commons Mathematics Library](http://commons.apache.org/proper/commons-math/)
The Apache common mathematics library is used for distribution and p-value calculations.
The `commons-math3-3.6.1.jar` archive is included in the COMPOSITEGRAPHER distribution and it must be in the CLASSPATH environment variable.  

##### [Google gson](https://github.com/google/gson)
The Google gson library is used for serialization/deserialization of the datasets.  
The `gson-2.6.2.jar` archive is included in the COMPOSITEGRAPHER distribution and it must be in the CLASSPATH environment variable. 


