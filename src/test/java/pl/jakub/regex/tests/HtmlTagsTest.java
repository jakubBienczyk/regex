package pl.jakub.regex.tests;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HtmlTagsTest {

    private HtmlTags htmlTags = new HtmlTags();

    @Test
    public void testCorrectTag1() {
        String input = "<a>This is a link</a>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is a correct html tag")
            .isTrue();
    }

    @Test
    public void testCorrectTag2() {
        String input = "<a/>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is a correct html tag")
            .isTrue();
    }

    @Test
    public void testCorrectTagWithArgument1() {
        String input = "<a href='https://google.com'/>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is a correct html tag")
            .isTrue();
    }

    @Test
    public void testCorrectTagWithArgument2() {
        String input = "<div class='test_style'>Test test</div>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is a correct html tag")
            .isTrue();
    }

    @Test
    public void testCorrectTagWithArgument3() {
        String input = "<div class='test_style'></div>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is a correct html tag")
            .isTrue();
    }

    @Test
    public void testCorrectShortTag() {
        String input = "<a/>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is a correct html tag")
            .isTrue();
    }

    @Test
    public void testIncorrectTag1() {
        String input = "<a>This is a link</b>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is an incorrect html tag")
            .isFalse();
    }

    @Test
    public void testIncorrectTag2() {
        String input = "<a>This is a link<a>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is an incorrect html tag")
            .isFalse();
    }

    @Test
    public void testIncorrectTag3() {
        String input = "<a>This is a link";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is an incorrect html tag")
            .isFalse();
    }

    @Test
    public void testIncorrectTag4() {
        String input = "<a>This is a link</a";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is an incorrect html tag")
            .isFalse();
    }

    @Test
    public void testIncorrectTag5() {
        String input = "text<a>This is a link</a>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is an incorrect html tag")
            .isFalse();
    }

    @Test
    public void testIncorrectTag6() {
        String input = "<a>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is an incorrect html tag")
            .isFalse();
    }

    @Test
    public void testIncorrectTag8() {
        String input = "< a/>";
        boolean htmlTag = htmlTags.isHtmlTag(input);
        assertThat(htmlTag)
            .as(input + " is an incorrect html tag")
            .isFalse();
    }

}