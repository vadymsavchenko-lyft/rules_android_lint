"""Android lint baseline regeneration rule."""

load(
    ":attrs.bzl",
    _ATTRS = "ATTRS",
)
load(
    ":impl.bzl",
    _process_android_lint_issues = "process_android_lint_issues",
)
load(
    ":providers.bzl",
    _AndroidLintResultsInfo = "AndroidLintResultsInfo",
)

def _impl(ctx):
    android_lint_results = _process_android_lint_issues(ctx, regenerate = True)

    inputs = []
    inputs.append(android_lint_results.output)

    return [
        DefaultInfo(
            runfiles = ctx.runfiles(files = inputs),
            files = depset([android_lint_results.output]),
        ),
    ] + android_lint_results.providers

android_lint_regenerate_baseline = rule(
    implementation = _impl,
    attrs = _ATTRS,
    doc = """Runs Android Lint with baseline suppression turned off and reports every finding.

    Lint's report and its baseline file are the same XML shape, so `<name>.xml` can be copied
    straight over the target's checked-in baseline to adopt the current set of findings. Unlike
    `android_lint_test` this is not a test rule: it is meant to be `bazel build`-ed in bulk and
    have its outputs copied back into the source tree.

    The rule takes no `baseline` attribute on purpose - the point is to ignore the existing one.
    """,
    provides = [
        _AndroidLintResultsInfo,
    ],
    toolchains = [
        "//toolchains:toolchain_type",
    ],
)
