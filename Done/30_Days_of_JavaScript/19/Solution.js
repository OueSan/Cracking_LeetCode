/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var index = 0
var tTimes = []

setTimeout = (f, t) => {
    tTimes[index] = t
    f()
}


Object.defineProperty(performance, "now", {value: () => 0, writable: true})

var promiseAll = async function(functions) {
    var start = performance.now()

    var errors = []
    var results = []
    for (var i = 0; i < functions.length; ++i) {
        try {
            index = i
            results[i] = await functions[i]()
        } catch (e) {
            console.log(e)
            errors[i] = e
        }
    }

    if (errors.length) {
        var min = 1000000
        var error
        errors.forEach((e, i) => {
            if (tTimes[i] < min) {
                error = e
                min = tTimes[i]
            }
        })
        performance.now = () => start + min
        throw error
    } else {
        var max = 0
        results.forEach((_, i) => {
            if (tTimes[i] > max) {
                max = tTimes[i]
            }
        })
        performance.now = () => start + max
        return results
    }
}