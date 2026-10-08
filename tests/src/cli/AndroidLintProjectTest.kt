package com.rules.android.lint.cli

import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.nio.file.Path

@RunWith(JUnit4::class)
class AndroidLintProjectTest {
  @Rule
  @JvmField
  var tmpDirectory = TemporaryFolder()

  private fun TemporaryFolder.newPath(name: String): Path = this.newFile(name).toPath()

  @Test
  fun `test asXMLString does produce correct project file content`() {
    assertThat(
      createProjectXMLString(
        moduleName = "test_module_name",
        rootDir = tmpDirectory.root.absolutePath,
        srcs = listOf(tmpDirectory.newPath("Foo.kt")),
        resources = listOf(tmpDirectory.newPath("foo.xml")),
        androidManifest = tmpDirectory.newPath("AndroidManifest.xml"),
        classpathJars = listOf(tmpDirectory.newPath("Foo.jar")),
        classpathAars = listOf(tmpDirectory.newPath("Foo.aar")),
        classpathExtractedAarDirectories =
          listOf(
            Pair(
              tmpDirectory.newPath("Bar.aar"),
              tmpDirectory.newFolder("tmp/unpacked_aars/bar/").toPath(),
            ),
          ),
        customLintChecks = listOf(tmpDirectory.newPath("tmp/unpacked_aars/bar/lint.jar")),
      ),
    ).isEqualTo(
      """
      <?xml version="1.0" encoding="UTF-8" standalone="no"?>
      <project>
        <root dir="{root}"/>
        <module android="true" name="test_module_name">
          <src file="{root}/Foo.kt"/>
          <resource file="{root}/foo.xml"/>
          <manifest file="{root}/AndroidManifest.xml"/>
          <classpath jar="{root}/Foo.jar"/>
          <aar file="{root}/Foo.aar"/>
          <aar extracted="{root}/tmp/unpacked_aars/bar" file="{root}/Bar.aar"/>
        </module>
        <lint-checks jar="{root}/tmp/unpacked_aars/bar/lint.jar"/>
      </project>

      """.trimIndent().replace("{root}", tmpDirectory.root.absolutePath),
    )
  }

  @Test
  fun `test extracted aar jars are added to the classpath`() {
    val extractedDir = tmpDirectory.newFolder("tmp/unpacked_aars/bar/").toPath()
    tmpDirectory.newFile("tmp/unpacked_aars/bar/classes.jar")
    tmpDirectory.newFolder("tmp/unpacked_aars/bar/libs/")
    tmpDirectory.newFile("tmp/unpacked_aars/bar/libs/inner.jar")
    tmpDirectory.newFile("tmp/unpacked_aars/bar/libs/notes.txt")

    assertThat(
      createProjectXMLString(
        moduleName = "test_module_name",
        rootDir = tmpDirectory.root.absolutePath,
        srcs = emptyList(),
        resources = emptyList(),
        androidManifest = null,
        classpathJars = emptyList(),
        classpathAars = emptyList(),
        classpathExtractedAarDirectories =
          listOf(
            Pair(tmpDirectory.newPath("Bar.aar"), extractedDir),
          ),
        customLintChecks = emptyList(),
      ),
    ).isEqualTo(
      """
      <?xml version="1.0" encoding="UTF-8" standalone="no"?>
      <project>
        <root dir="{root}"/>
        <module android="false" name="test_module_name">
          <aar extracted="{root}/tmp/unpacked_aars/bar" file="{root}/Bar.aar"/>
          <classpath jar="{root}/tmp/unpacked_aars/bar/classes.jar"/>
          <classpath jar="{root}/tmp/unpacked_aars/bar/libs/inner.jar"/>
        </module>
      </project>

      """.trimIndent().replace("{root}", tmpDirectory.root.absolutePath),
    )
  }
}
