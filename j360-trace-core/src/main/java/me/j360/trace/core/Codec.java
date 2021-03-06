/**
 * Copyright 2015-2016 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package me.j360.trace.core;

import me.j360.trace.core.internal.JsonCodec;

import java.util.List;

/**
 * Methods make an attempt to perform codec operations, failing to null.
 */
public interface Codec {

  JsonCodec JSON = new JsonCodec();

  /** throws {@linkplain IllegalArgumentException} if the span couldn't be decoded */
  Span readSpan(byte[] bytes);

  int sizeInBytes(Span value);

  byte[] writeSpan(Span value);

  /** throws {@linkplain IllegalArgumentException} if the spans couldn't be decoded */
  List<Span> readSpans(byte[] bytes);

  byte[] writeSpans(List<Span> value);

  byte[] writeTraces(List<List<Span>> value);

  /** throws {@linkplain IllegalArgumentException} if the dependency link couldn't be decoded */
  DependencyLink readDependencyLink(byte[] bytes);

  byte[] writeDependencyLink(DependencyLink value);

  /** throws {@linkplain IllegalArgumentException} if the dependency links couldn't be decoded */
  List<DependencyLink> readDependencyLinks(byte[] bytes);

  byte[] writeDependencyLinks(List<DependencyLink> value);
}
