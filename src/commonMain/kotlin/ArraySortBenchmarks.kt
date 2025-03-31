@file:OptIn(ExperimentalUnsignedTypes::class)

package org.example

import kotlinx.benchmark.*
import kotlin.random.Random

// Benchmarks are based on a benchmark attached to https://youtrack.jetbrains.com/issue/KT-76423

@State(Scope.Benchmark)
abstract class SortBenchmarkBase {
    @Param("10", "100", "10000")
    var arrayLength: Int = 0

    protected val random = Random(42)
}

fun ByteArray.alternativeSorted(): List<Byte> = sortedArray().asList()
fun ShortArray.alternativeSorted(): List<Short> = sortedArray().asList()
fun IntArray.alternativeSorted(): List<Int> = sortedArray().asList()
fun LongArray.alternativeSorted(): List<Long> = sortedArray().asList()
fun FloatArray.alternativeSorted(): List<Float> = sortedArray().asList()
fun DoubleArray.alternativeSorted(): List<Double> = sortedArray().asList()

fun UByteArray.alternativeSorted(): List<UByte> = sortedArray().asList()
fun UShortArray.alternativeSorted(): List<UShort> = sortedArray().asList()
fun UIntArray.alternativeSorted(): List<UInt> = sortedArray().asList()
fun ULongArray.alternativeSorted(): List<ULong> = sortedArray().asList()

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class ByteArraySortBenchmark : SortBenchmarkBase() {
    private var array = ByteArray(0)

    @Setup
    fun setup() {
        array = ByteArray(arrayLength) { random.nextInt().toByte() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class ShortArraySortBenchmark : SortBenchmarkBase() {
    private var array = ShortArray(0)

    @Setup
    fun setup() {
        array = ShortArray(arrayLength) { random.nextInt().toShort() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class IntArraySortBenchmark : SortBenchmarkBase() {
    private var array = IntArray(0)

    @Setup
    fun setup() {
        array = IntArray(arrayLength) { random.nextInt() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class LongArraySortBenchmark : SortBenchmarkBase() {
    private var array = LongArray(0)

    @Setup
    fun setup() {
        array = LongArray(arrayLength) { random.nextLong() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class FloatArraySortBenchmark : SortBenchmarkBase() {
    private var array = FloatArray(0)

    @Setup
    fun setup() {
        array = FloatArray(arrayLength) { random.nextFloat() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class DoubleArraySortBenchmark : SortBenchmarkBase() {
    private var array = DoubleArray(0)

    @Setup
    fun setup() {
        array = DoubleArray(arrayLength) { random.nextDouble() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class UByteArraySortBenchmark : SortBenchmarkBase() {
    private var array = UByteArray(0)

    @Setup
    fun setup() {
        array = UByteArray(arrayLength) { random.nextInt().toUByte() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class UShortArraySortBenchmark : SortBenchmarkBase() {
    private var array = UShortArray(0)

    @Setup
    fun setup() {
        array = UShortArray(arrayLength) { random.nextInt().toUShort() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class UIntArraySortBenchmark : SortBenchmarkBase() {
    private var array = UIntArray(0)

    @Setup
    fun setup() {
        array = UIntArray(arrayLength) { random.nextInt().toUInt() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}

@State(Scope.Benchmark)
@Warmup(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
open class ULongArraySortBenchmark : SortBenchmarkBase() {
    private var array = ULongArray(0)

    @Setup
    fun setup() {
        array = ULongArray(arrayLength) { random.nextLong().toULong() }
    }

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        blackhole.consume(array.sorted())
    }

    @Benchmark
    fun patch(blackhole: Blackhole) {
        blackhole.consume(array.alternativeSorted())
    }
}
