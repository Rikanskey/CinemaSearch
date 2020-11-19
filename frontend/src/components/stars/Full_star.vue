<template>
  <svg xmlns='http://www.w3.org/2000/svg'
       width='32'
       height='31'
       viewBox='0 0 32 31'
       fill='#f66600'>
    <path fill-rule='evenodd'
          d='M 16.771 24.13
             L 26.522 31.227 22.79 19.767 32.541 12.828 20.582 12.828 16.771 1 12.959 12.828 1 12.828 10.751 19.767 7.019 31.227z'
          transform='translate(-.89 -.309)'/>
  </svg>
</template>

<script>
export default {
name: "Full_star",
  default: {
    props: {
      // Имя файла (без расширения)
      iconName: {
        type: String,
        required: true
      },

      // Ширина
      width: {
        type: [Number, String],
        default: 32
      },

      // Высота
      height: {
        type: [Number, String],
        default: 31
      }
    }
  }
}
</script>

<style scoped>

</style>