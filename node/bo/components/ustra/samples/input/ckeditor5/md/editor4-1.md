HTML을 직접 입력할 수 있는 기능을 제공하는 GeneralHtmlSupport 플러그인은 Source Editing 사용 시 입력할 수 있는 HTML 유형을 지정하거나 막는 기능을 제공한다.
- General HTML Support : https://ckeditor.com/docs/ckeditor5/40.0.0/features/html/general-html-support.html

위의 링크에서 볼 수 있듯이 각 태그의 명칭, styles, classes, attributes 등에 설정할 수 있는 항목을 지정할 수 있으며 각 항목별로 설정할 수 있는 유형의 다음과 같다.
```typescript
[
    {
        // The element name to enable and/or extend with
        // the following styles, classes and other attributes.
        name: string|regexp,

        // Styles to allow (by name, name and value or just all).
        styles: object<string=>true|string|regexp>|array<string>|true,

        // Classes to allow (by name or just all).
        classes: array<string|regexp>|true,

        // Other attributes to allow (by name, name and value or just all).
        attributes: object<string=>true|string|regexp>|array<string>|true,
    }
]
```

위와 같이 설정가능한 유형으로 다음과 같이 세부적인 가용 태그 및 속성 정보를 세팅할 수 있다.
```typescript
htmlSupport: {
    allow: [
        // Enables plain <div> elements.
        {
            name: 'div'
        },

        // Enables plain <div>, <section> and <article> elements.
        {
            name: /^(div|section|article)$/
        },

        // Enables <div>s with all inline styles (but no other attributes).
        {
            name: 'div',
            styles: true
        },

        // Enables <div>s with foo and bar classes.
        {
            name: 'div',
            classes: [ 'foo', 'bar' ]
        },

        // Adds support for `foo` and `bar` classes to the already supported
        // <p> elements (those are enabled by the dedicated paragraph feature).
        {
            name: 'p',
            classes: [ 'foo', 'bar' ]
        },

        // Enables <div>s with foo="true" attribute and bar attribute that
        // can accept any value (boolean `true` value works as an asterisk).
        {
            name: 'div',
            attributes: {
                foo: 'true',
                bar: true
            }
        },

        // Adds support for style="color: *" to the already supported
        // <p> and <h2-h4> elements.
        {
            name: /^(p|h[2-4])$/',
            styles: { 'color': true }
        },
}
```