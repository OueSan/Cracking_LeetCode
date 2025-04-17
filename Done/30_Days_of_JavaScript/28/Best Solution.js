class EventEmitter {

    constructor() {
      this.events = {}
    }
  
    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
  
      let value = this.events[eventName];
  
      if (!value) {
        this.events[eventName] = [];
      }
  
      this.events[eventName].push(callback)
  
      return {
        unsubscribe: () => {
  
          let callbackIndex = this.events[eventName].indexOf(callback);
  
          if (callbackIndex >= 0) {
            this.events[eventName].splice(callbackIndex, 1)
          }
        }
      };
    }
  
    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
      if (!this.events[eventName]) {
        this.events[eventName] = [];
      }
  
      let values = this.events[eventName];
  
      let result = [];
  
      for (let callback of values) {
        result.push(callback(...args))
      }
  
      return result
    }
  }
  
  /**
  * const emitter = new EventEmitter();
  *
  * // Subscribe to the onClick event with onClickCallback
  * function onClickCallback() { return 99 }
  * const sub = emitter.subscribe('onClick', onClickCallback);
  *
  * emitter.emit('onClick'); // [99]
  * sub.unsubscribe(); // undefined
  * emitter.emit('onClick'); // []
  */