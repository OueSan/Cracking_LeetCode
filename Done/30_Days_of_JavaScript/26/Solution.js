/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
  const result = [];
  flatRecursive(arr, n, 0, result);
  return result;
};

var flatRecursive = function (arr, n, counter, result) {
  if (counter > n || !Array.isArray(arr)) {
      result.push(arr);
      return;
  }

  
  for (let i = 0; i < arr.length; i++) {
      if (Array.isArray(arr[i])) {
          flatRecursive(arr[i], n, counter + 1, result);
      } else {
          result.push(arr[i]);
      }
      
  }
};