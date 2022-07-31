package WeeklyQuestion;
// week4


// In a certain city there are x number of villages represented in an array where a[i] 
// represents their grade. Each village is assigned grades based on their population count. 
// you are assigned task to distribute
// wheat container to each village. Write an algorithm to return the minimum number of 
// containers required to distribute wheat to each village such that each village must 
// get at least one container and villages with higher grade must receive more container;
// input: grades = [5,2,6]
// output:6
// explain you can distribute first 2nd village 1 container and 1st village 2 container and 
// third village 3 container

public class Villager {
    public class wheatContainer {

        // sorting array
        static void forEachVillage(int array[]) {
            for (int i = 1; i < array.length; i++) {
                int j = i;
                int a = array[i];
                while ((j > 0) && (array[j - 1] > a)) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = a;
             }
         }

//function to calculate the number of container required
        static void forCurrentVillage(int array[]){

        //declaring variables
            int a;
            int total_container = 0;
            int previous_value = 0;
            int forthisvillage = 0;

            for (a = 0; a < array.length; a++) {
              if (array[a] != previous_value) {
                    previous_value = array[a];
                    forthisvillage = forthisvillage + 1;
                    total_container = total_container + forthisvillage;
            } else {
                     previous_value = array[a];
                    total_container = total_container + forthisvillage;
            }
            }

//printing the no of containers required
             System.out.println("The minimum number of containers required to distribute wheat to each village is: " + total_container);
         }

 //calling the main function
        public static void main(String[] args) {

            // initializing an array
            int array[] = { 5,2,6 };
            //declaring variables
            int a;
            int total_container = 0;
            int previous_value = 0;
            int forthisvillage = 0;

    for (a = 0; a < array.length; a++) {
            if (array[a] != previous_value) {
                    previous_value = array[a];
                    forthisvillage = forthisvillage + 1;

                    total_container = total_container + forthisvillage;
            } else {
                    previous_value = array[a];
                    total_container = total_container + forthisvillage;
            }
        }
            //printing the no of containers required
            System.out.println("The minimum number of containers required to distribute wheat to each village is: " + total_container);


            // sorting the array
            forEachVillage(array);

            // //calling the function to calculate the no of containers required
            // forCurrentVillage(array);
        }
    }
}