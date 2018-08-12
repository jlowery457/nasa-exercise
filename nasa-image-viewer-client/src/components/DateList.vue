<template>
  <el-menu-item-group title="Dates">
    <DateListItem
      v-for="(date, index) in dates"
      :date="date"
      :key="index"
      :index="dateIndex(index, rover)"
      :rover="rover"
    />
  </el-menu-item-group>
</template>
<script>
  import DateListItem from './DateListItem';
  export default {
    components: {
      DateListItem
    },
    props: {
      dates: {
        required: true,
        type: Array
      },
      rover: {
        required: true,
        type: Object
      }
    },
    methods: {
      dateIndex(index, rover) {
        return `${rover.id}-${index}`;
      }
    }
  }
</script>

