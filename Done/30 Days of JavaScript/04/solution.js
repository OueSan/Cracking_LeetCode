/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createcounter = function(init) {
  var num = init;
  return {
      increment : function(){
          init = init + 1;
          return init;
      },
      decrement : function(){
          init = init -1;
          return init;
      },
      reset : function (){
          init = num;
          return init;
      }
  }
};

/**
* const counter = createCounter(5)
* counter.increment(); // 6
* counter.reset(); // 5
* counter.decrement(); // 4
*/