# Task 1-2

# Task 3
1. Write your own functional interface ThreeFunction (it takes three arguments and produce result).</br>
2. Implement this with two different lambdas </br>
3. Provide client code with usage of this lambdas </br>
# Task 4
1. Create the following classes: </br>
Author with fields: </br>
String name </br>
short age </br>
List books </br>
Book with fields </br>
String title </br>
List authors </br>
int numberOfPages </br>
2. Create two arrays: Author[] authors and Book[] books. Their elements must use elements from the neighboring array. </br>
3. Create a stream of books and then: </br>
check if some/all book(s) have more than 200 pages; </br>
find the books with max and min number of pages; </br>
filter books with only single author; </br>
sort the books by number of pages/title; </br>
get list of all titles; </br>
print them using forEach method; </br>
get distinct list of all authors </br>
4. Use peek method for debugging intermediate streams during execution the previous task. </br>
5. Use parallel stream with subtask #3. </br>
6. Analyze with mentor results of previous subtask execution, explain him the difference between stream and parallel stream. </br>
7. Use the Optional type for determining the title of the biggest book of some author. </br>
# Task 5
Define a complex class A with a few fields with different types. This class will be an item in collection.
Define a few methods which calculates some stat over the fields of the A class.
Make stream from the collection of A’s instances.
Write custom collector to accumulate the information from elements of your stream. </br>
1. Implement Collector interface </br>
2. Don’t forget the final transformation </br
3. Try to use Characteristics for the optimization purpose.</br>
4. Add tests for your collector.
   Test your Collector with the parallel streams for significant amount of items in stream.</br>