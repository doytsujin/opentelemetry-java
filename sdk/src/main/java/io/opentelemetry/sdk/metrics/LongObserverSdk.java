/*
 * Copyright 2020, OpenTelemetry Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.opentelemetry.sdk.metrics;

import io.opentelemetry.metrics.LongObserver;
import io.opentelemetry.sdk.metrics.common.InstrumentValueType;

final class LongObserverSdk extends AbstractObserver implements LongObserver {
  LongObserverSdk(
      InstrumentDescriptor descriptor,
      MeterProviderSharedState meterProviderSharedState,
      MeterSharedState meterSharedState,
      boolean monotonic) {
    super(
        descriptor,
        InstrumentValueType.LONG,
        meterProviderSharedState,
        meterSharedState,
        monotonic);
  }

  @Override
  public void setCallback(Callback<LongObserver.ResultLongObserver> metricUpdater) {
    throw new UnsupportedOperationException("to be implemented");
  }

  static final class Builder extends AbstractObserver.Builder<LongObserver.Builder, LongObserver>
      implements LongObserver.Builder {

    Builder(
        String name,
        MeterProviderSharedState meterProviderSharedState,
        MeterSharedState meterSharedState) {
      super(name, meterProviderSharedState, meterSharedState);
    }

    @Override
    Builder getThis() {
      return this;
    }

    @Override
    public LongObserverSdk build() {
      return register(
          new LongObserverSdk(
              getInstrumentDescriptor(),
              getMeterProviderSharedState(),
              getMeterSharedState(),
              isMonotonic()));
    }
  }
}
