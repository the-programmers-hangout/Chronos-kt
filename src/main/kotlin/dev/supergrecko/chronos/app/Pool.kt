package dev.supergrecko.chronos.app

/**
 * A pool is a collection of [T] with a capacity.
 *
 * It acts like a bucket which means it will gradually grow until it reaches
 * its set capacity, at which point it will reject any new insertions.
 */
class Pool<T>(
    public val capacity: Int = 64
) {
    private val pool: MutableList<T> = mutableListOf()

    /**
     * Inserts an item into the pool, if possible
     */
    public fun insert(item: T) {
        if (pool.size == capacity) {
            throw IllegalStateException("Pool has reached its capacity")
        }

        pool.add(item)
    }
}