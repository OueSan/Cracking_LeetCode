/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
  if(typeof obj === "object"){
      return Object.keys(obj).length < 1;
  } else {
      return obj.length < 1
  }
};