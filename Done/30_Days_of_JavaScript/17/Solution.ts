class TimeLimitedCache {

  cache: Map<number, {value: number, duration: NodeJS.Timeout}>;

  constructor() {
      this.cache = new Map();
  }

  set(key: number, value: number, duration: number): boolean {
      const found = this.cache.has(key);
      if (found) {
          clearTimeout(this.cache.get(key)!.duration);
      }

      this.cache.set(key, {value, duration: setTimeout(() => this.cache.delete(key), duration)});
      return found;
  }

  get(key: number): number {
      return this.cache.has(key) ? this.cache.get(key)!.value : -1;
  }

  count(): number {
      return this.cache.size;
  }
}

/**
* const timeLimitedCache = new TimeLimitedCache()
* timeLimitedCache.set(1, 42, 1000); // false
* timeLimitedCache.get(1) // 42
* timeLimitedCache.count() // 1
*/