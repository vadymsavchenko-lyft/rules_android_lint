<!-- Generated with Stardoc: http://skydoc.bazel.build -->

Android Lint rules

<a id="android_lint"></a>

## android_lint

<pre>
load("@rules_android_lint//rules:defs.bzl", "android_lint")

android_lint(<a href="#android_lint-name">name</a>, <a href="#android_lint-deps">deps</a>, <a href="#android_lint-srcs">srcs</a>, <a href="#android_lint-android_lint_config">android_lint_config</a>, <a href="#android_lint-autofix">autofix</a>, <a href="#android_lint-custom_rules">custom_rules</a>, <a href="#android_lint-disable_checks">disable_checks</a>,
             <a href="#android_lint-enable_checks">enable_checks</a>, <a href="#android_lint-is_test_sources">is_test_sources</a>, <a href="#android_lint-lib">lib</a>, <a href="#android_lint-manifest">manifest</a>, <a href="#android_lint-resource_files">resource_files</a>, <a href="#android_lint-warnings_as_errors">warnings_as_errors</a>)
</pre>



**ATTRIBUTES**


| Name  | Description | Type | Mandatory | Default |
| :------------- | :------------- | :------------- | :------------- | :------------- |
| <a id="android_lint-name"></a>name |  A unique name for this target.   | <a href="https://bazel.build/concepts/labels#target-names">Name</a> | required |  |
| <a id="android_lint-deps"></a>deps |  Dependencies that should be on the classpath during execution.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint-srcs"></a>srcs |  Sources to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | required |  |
| <a id="android_lint-android_lint_config"></a>android_lint_config |  Lint Android Lint configuration file.   | <a href="https://bazel.build/concepts/labels">Label</a> | optional |  `None`  |
| <a id="android_lint-autofix"></a>autofix |  Enables lint autofix. This is a no-op right now.   | Boolean | optional |  `False`  |
| <a id="android_lint-custom_rules"></a>custom_rules |  Custom lint rules to run.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint-disable_checks"></a>disable_checks |  List of checks to disable.   | List of strings | optional |  `[]`  |
| <a id="android_lint-enable_checks"></a>enable_checks |  List of checks to enable.   | List of strings | optional |  `[]`  |
| <a id="android_lint-is_test_sources"></a>is_test_sources |  True when linting test sources, otherwise false.   | Boolean | optional |  `False`  |
| <a id="android_lint-lib"></a>lib |  The target being linted. This is needed to get the compiled R files.   | <a href="https://bazel.build/concepts/labels">Label</a> | required |  |
| <a id="android_lint-manifest"></a>manifest |  Android manifest to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">Label</a> | optional |  `None`  |
| <a id="android_lint-resource_files"></a>resource_files |  Android resource files to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint-warnings_as_errors"></a>warnings_as_errors |  When true, lint will treat warnings as errors.   | Boolean | optional |  `False`  |


<a id="android_lint_regenerate_baseline"></a>

## android_lint_regenerate_baseline

<pre>
load("@rules_android_lint//rules:defs.bzl", "android_lint_regenerate_baseline")

android_lint_regenerate_baseline(<a href="#android_lint_regenerate_baseline-name">name</a>, <a href="#android_lint_regenerate_baseline-deps">deps</a>, <a href="#android_lint_regenerate_baseline-srcs">srcs</a>, <a href="#android_lint_regenerate_baseline-android_lint_config">android_lint_config</a>, <a href="#android_lint_regenerate_baseline-autofix">autofix</a>, <a href="#android_lint_regenerate_baseline-custom_rules">custom_rules</a>,
                                 <a href="#android_lint_regenerate_baseline-disable_checks">disable_checks</a>, <a href="#android_lint_regenerate_baseline-enable_checks">enable_checks</a>, <a href="#android_lint_regenerate_baseline-is_test_sources">is_test_sources</a>, <a href="#android_lint_regenerate_baseline-lib">lib</a>, <a href="#android_lint_regenerate_baseline-manifest">manifest</a>,
                                 <a href="#android_lint_regenerate_baseline-resource_files">resource_files</a>, <a href="#android_lint_regenerate_baseline-warnings_as_errors">warnings_as_errors</a>)
</pre>

Runs Android Lint with baseline suppression turned off and reports every finding.

Lint's report and its baseline file are the same XML shape, so `<name>.xml` can be copied
straight over the target's checked-in baseline to adopt the current set of findings. Unlike
`android_lint_test` this is not a test rule: it is meant to be `bazel build`-ed in bulk and
have its outputs copied back into the source tree.

The rule takes no `baseline` attribute on purpose - the point is to ignore the existing one.

**ATTRIBUTES**


| Name  | Description | Type | Mandatory | Default |
| :------------- | :------------- | :------------- | :------------- | :------------- |
| <a id="android_lint_regenerate_baseline-name"></a>name |  A unique name for this target.   | <a href="https://bazel.build/concepts/labels#target-names">Name</a> | required |  |
| <a id="android_lint_regenerate_baseline-deps"></a>deps |  Dependencies that should be on the classpath during execution.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint_regenerate_baseline-srcs"></a>srcs |  Sources to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | required |  |
| <a id="android_lint_regenerate_baseline-android_lint_config"></a>android_lint_config |  Lint Android Lint configuration file.   | <a href="https://bazel.build/concepts/labels">Label</a> | optional |  `None`  |
| <a id="android_lint_regenerate_baseline-autofix"></a>autofix |  Enables lint autofix. This is a no-op right now.   | Boolean | optional |  `False`  |
| <a id="android_lint_regenerate_baseline-custom_rules"></a>custom_rules |  Custom lint rules to run.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint_regenerate_baseline-disable_checks"></a>disable_checks |  List of checks to disable.   | List of strings | optional |  `[]`  |
| <a id="android_lint_regenerate_baseline-enable_checks"></a>enable_checks |  List of checks to enable.   | List of strings | optional |  `[]`  |
| <a id="android_lint_regenerate_baseline-is_test_sources"></a>is_test_sources |  True when linting test sources, otherwise false.   | Boolean | optional |  `False`  |
| <a id="android_lint_regenerate_baseline-lib"></a>lib |  The target being linted. This is needed to get the compiled R files.   | <a href="https://bazel.build/concepts/labels">Label</a> | required |  |
| <a id="android_lint_regenerate_baseline-manifest"></a>manifest |  Android manifest to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">Label</a> | optional |  `None`  |
| <a id="android_lint_regenerate_baseline-resource_files"></a>resource_files |  Android resource files to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint_regenerate_baseline-warnings_as_errors"></a>warnings_as_errors |  When true, lint will treat warnings as errors.   | Boolean | optional |  `False`  |


<a id="android_lint_test"></a>

## android_lint_test

<pre>
load("@rules_android_lint//rules:defs.bzl", "android_lint_test")

android_lint_test(<a href="#android_lint_test-name">name</a>, <a href="#android_lint_test-deps">deps</a>, <a href="#android_lint_test-srcs">srcs</a>, <a href="#android_lint_test-android_lint_config">android_lint_config</a>, <a href="#android_lint_test-autofix">autofix</a>, <a href="#android_lint_test-baseline">baseline</a>, <a href="#android_lint_test-custom_rules">custom_rules</a>,
                  <a href="#android_lint_test-disable_checks">disable_checks</a>, <a href="#android_lint_test-enable_checks">enable_checks</a>, <a href="#android_lint_test-is_test_sources">is_test_sources</a>, <a href="#android_lint_test-lib">lib</a>, <a href="#android_lint_test-manifest">manifest</a>, <a href="#android_lint_test-resource_files">resource_files</a>,
                  <a href="#android_lint_test-warnings_as_errors">warnings_as_errors</a>)
</pre>



**ATTRIBUTES**


| Name  | Description | Type | Mandatory | Default |
| :------------- | :------------- | :------------- | :------------- | :------------- |
| <a id="android_lint_test-name"></a>name |  A unique name for this target.   | <a href="https://bazel.build/concepts/labels#target-names">Name</a> | required |  |
| <a id="android_lint_test-deps"></a>deps |  Dependencies that should be on the classpath during execution.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint_test-srcs"></a>srcs |  Sources to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | required |  |
| <a id="android_lint_test-android_lint_config"></a>android_lint_config |  Lint Android Lint configuration file.   | <a href="https://bazel.build/concepts/labels">Label</a> | optional |  `None`  |
| <a id="android_lint_test-autofix"></a>autofix |  Enables lint autofix. This is a no-op right now.   | Boolean | optional |  `False`  |
| <a id="android_lint_test-baseline"></a>baseline |  Lint baseline file.   | <a href="https://bazel.build/concepts/labels">Label</a> | optional |  `None`  |
| <a id="android_lint_test-custom_rules"></a>custom_rules |  Custom lint rules to run.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint_test-disable_checks"></a>disable_checks |  List of checks to disable.   | List of strings | optional |  `[]`  |
| <a id="android_lint_test-enable_checks"></a>enable_checks |  List of checks to enable.   | List of strings | optional |  `[]`  |
| <a id="android_lint_test-is_test_sources"></a>is_test_sources |  True when linting test sources, otherwise false.   | Boolean | optional |  `False`  |
| <a id="android_lint_test-lib"></a>lib |  The target being linted. This is needed to get the compiled R files.   | <a href="https://bazel.build/concepts/labels">Label</a> | required |  |
| <a id="android_lint_test-manifest"></a>manifest |  Android manifest to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">Label</a> | optional |  `None`  |
| <a id="android_lint_test-resource_files"></a>resource_files |  Android resource files to run Android Lint against.   | <a href="https://bazel.build/concepts/labels">List of labels</a> | optional |  `[]`  |
| <a id="android_lint_test-warnings_as_errors"></a>warnings_as_errors |  When true, lint will treat warnings as errors.   | Boolean | optional |  `False`  |


<a id="AndroidLintResultsInfo"></a>

## AndroidLintResultsInfo

<pre>
load("@rules_android_lint//rules:defs.bzl", "AndroidLintResultsInfo")

AndroidLintResultsInfo(<a href="#AndroidLintResultsInfo-output">output</a>)
</pre>

Info needed to evaluate lint results

**FIELDS**

| Name  | Description |
| :------------- | :------------- |
| <a id="AndroidLintResultsInfo-output"></a>output |  The Android Lint baseline output    |


