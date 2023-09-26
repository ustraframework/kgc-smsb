```html
<UBox direction="col">
  <UItem :baseSize="100">
    <div class="box3">Top</div>
  </UItem>
  <UItem :ratio="1">
    <UBox direction="row">
      <UItem ratio="1"><div class="box1">Left</div> </UItem>
      <UItem ratio="1">
        <UBox direction="col">
          <UItem ratio="1"><div class="box2">Right1</div> </UItem>
          <UItem ratio="1"><div class="box2">Right2</div> </UItem>
        </UBox>
      </UItem>
    </UBox>
  </UItem>
</UBox>
```
