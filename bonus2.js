// Create a function that returns the sum of the two lowest positive numbers given an array of minimum 4 integers. No floats or empty arrays will be passed.

// For example, when an array is passed like [19, 5, 42, 2, 77], the output should be 7.

// [10, 343445353, 3453445, 3453545353453] should return 3453455.

function isInteger(value){
    return Number.isInteger(value);
  }

function sumTwoSmallestNumbers(array){
    let newArr = [...array];
    if (newArr.length >= 4 && newArr.every(isInteger) == true){
    newArr.sort(function(a, b){return a-b});
    return newArr[0] + newArr[1]; 
} else {
    return "Invalid Array"
}
}

console.log(sumTwoSmallestNumbers([5, 8, 12, 19, 22])); // 13 , "Sum should be 13");
console.log(sumTwoSmallestNumbers([15, 28, 4, 2, 43])); // 6 , "Sum should be 6");
console.log(sumTwoSmallestNumbers([3, 87, 45, 12, 7])); // 10 , "Sum should be 10");
console.log(sumTwoSmallestNumbers([23, 71, 33, 82, 1])); //  24 , "Sum should be 24");
console.log(sumTwoSmallestNumbers([52, 76, 14, 12, 4])); //  16 , "Sum should be 16");


