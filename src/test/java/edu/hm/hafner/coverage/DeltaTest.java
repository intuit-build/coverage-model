package edu.hm.hafner.coverage;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import static edu.hm.hafner.coverage.assertions.Assertions.*;

class DeltaTest {
    @Test
    void shouldFormatPercentageWithSign() {
        var positive = new Delta(Metric.COHESION, 2, 3);

        assertThat(positive.asInteger()).isEqualTo(1);
        assertThat(positive.asDouble()).isEqualTo(2.0 / 3);
        assertThat(positive.asRounded()).isEqualTo(0.67);

        assertThat(positive.asText(Locale.ENGLISH)).isEqualTo("+66.67%");
        assertThat(positive.asInformativeText(Locale.ENGLISH)).isEqualTo("+66.67%");
        assertThat(positive.serialize()).isEqualTo("COHESION: 2:3");

        var negative = new Delta(Metric.COHESION, -2, 3);

        assertThat(negative.asInteger()).isEqualTo(-1);
        assertThat(negative.asDouble()).isEqualTo(-2.0 / 3);
        assertThat(negative.asRounded()).isEqualTo(-0.67);

        assertThat(negative.asText(Locale.ENGLISH)).isEqualTo("-66.67%");
        assertThat(negative.asInformativeText(Locale.ENGLISH)).isEqualTo("-66.67%");
        assertThat(negative.serialize()).isEqualTo("COHESION: -2:3");

        var zero = new Delta(Metric.COHESION, 0);

        assertThat(zero.asInteger()).isEqualTo(0);
        assertThat(zero.asDouble()).isEqualTo(0);
        assertThat(zero.asRounded()).isEqualTo(0);

        assertThat(zero.asText(Locale.ENGLISH)).isEqualTo("±0%");
        assertThat(zero.asInformativeText(Locale.ENGLISH)).isEqualTo("±0%");
        assertThat(zero.serialize()).isEqualTo("COHESION: 0");
    }

    @Test
    void shouldFormatCoverageWithSign() {
        var positive = new Delta(Metric.LINE, 200, 3);

        assertThat(positive.asInteger()).isEqualTo(67);
        assertThat(positive.asDouble()).isEqualTo(200.0 / 3);
        assertThat(positive.asRounded()).isEqualTo(66.67);

        assertThat(positive.asText(Locale.ENGLISH)).isEqualTo("+66.67%");
        assertThat(positive.asInformativeText(Locale.ENGLISH)).isEqualTo("+66.67%");
        assertThat(positive.serialize()).isEqualTo("LINE: 200:3");

        var negative = new Delta(Metric.LINE, -200, 3);

        assertThat(negative.asInteger()).isEqualTo(-67);
        assertThat(negative.asDouble()).isEqualTo(-200.0 / 3);
        assertThat(negative.asRounded()).isEqualTo(-66.67);

        assertThat(negative.asText(Locale.ENGLISH)).isEqualTo("-66.67%");
        assertThat(negative.asInformativeText(Locale.ENGLISH)).isEqualTo("-66.67%");
        assertThat(negative.serialize()).isEqualTo("LINE: -200:3");

        var zero = new Delta(Metric.LINE, 0);

        assertThat(zero.asInteger()).isEqualTo(0);
        assertThat(zero.asDouble()).isEqualTo(0);
        assertThat(zero.asRounded()).isEqualTo(0);

        assertThat(zero.asText(Locale.ENGLISH)).isEqualTo("±0%");
        assertThat(zero.asInformativeText(Locale.ENGLISH)).isEqualTo("±0%");
        assertThat(zero.serialize()).isEqualTo("LINE: 0");
    }

    @Test
    void shouldFormatIntegerWithSign() {
        var positive = new Delta(Metric.LOC, 2);

        assertThat(positive.asInteger()).isEqualTo(2);
        assertThat(positive.asDouble()).isEqualTo(2.0);
        assertThat(positive.asRounded()).isEqualTo(2);

        assertThat(positive.asText(Locale.ENGLISH)).isEqualTo("+2");
        assertThat(positive.asInformativeText(Locale.ENGLISH)).isEqualTo("+2");
        assertThat(positive.serialize()).isEqualTo("LOC: 2");

        var negative = new Delta(Metric.LOC, -2);

        assertThat(negative.asInteger()).isEqualTo(-2);
        assertThat(negative.asDouble()).isEqualTo(-2.0);
        assertThat(negative.asRounded()).isEqualTo(-2);

        assertThat(negative.asText(Locale.ENGLISH)).isEqualTo("-2");
        assertThat(negative.asInformativeText(Locale.ENGLISH)).isEqualTo("-2");
        assertThat(negative.serialize()).isEqualTo("LOC: -2");

        var zero = new Delta(Metric.LOC, 0);

        assertThat(zero.asInteger()).isEqualTo(0);
        assertThat(zero.asDouble()).isEqualTo(0);
        assertThat(zero.asRounded()).isEqualTo(0);

        assertThat(zero.asText(Locale.ENGLISH)).isEqualTo("±0");
        assertThat(zero.asInformativeText(Locale.ENGLISH)).isEqualTo("±0");
        assertThat(zero.serialize()).isEqualTo("LOC: 0");
    }
}
