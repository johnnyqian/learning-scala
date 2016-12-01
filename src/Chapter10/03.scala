/**
  * Created by Johnny Qian on 11/28/16.
  */

package chapter10

import scala.collection.immutable.BitSet

/**
  * lin(BitSet) = BitSet >> lin(Serializable) >> lin(BitSetLike) >> lin(collection.BitSet) >> lin(SortedSet) >> lin(AbstractSet)
  *
  * lin(BitSet) = BitSet >> Serializable >> java.io.Serializable >> collection.BitSet >>  BitSetLike >> Sorted >>
  *               collection.SortedSet >> SortedSetLike >> Set >> Setlike >> Subtractable >> GenSet >> GenericSetTemplate >>
  *               GenSetLike >> Iterable >> IterableLike >> Equals >> Traversable >> GenIterable >> GenTraversable >>
  *               GenericTraversableTemplate >> HasNewBuilder >> TraversableLike >> GenTraversableLike >> Parallelizable >>
  *               TraversableOnce >> GenTraversableOnce >> FilterMonadic >> Any >> (a) => Boolean >> AnyRef >> AbstractSet
  */