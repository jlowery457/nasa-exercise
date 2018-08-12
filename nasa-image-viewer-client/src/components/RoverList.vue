<template>
  <div>
    <RoverListItem
      v-for="rover in rovers"
      :rover="rover"
      :key="rover.id"
      :dates="dates"/>
  </div>
</template>
<script>
  import RoverListItem from './RoverListItem';
  export default {
    components: {
      RoverListItem
    },
    props: {
      rovers: {
        required: true,
        type: Array
      },
      dates: {
        required: true,
        type: Array
      }
    }
  }
</script>
