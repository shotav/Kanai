<script lang="ts">
	export let content: string;
</script>

<main>
  <div id="editor" contenteditable="true">{content}</div>
</main>

<style lang="less">
  :global(html, body, main) {
    padding: 0;
    margin: 0;
    width: 100%;
    height: 100vh;
    font-family: FiraCode, monospace;

    @font-face {
      font-family: FiraCode;
      src: url("/fonts/FiraCode.ttf");
    }
  }
  #editor {
    min-width: 100%;
    min-height: 100%;
    background-color: black;
    color: white;
    outline: none;
  }
</style>