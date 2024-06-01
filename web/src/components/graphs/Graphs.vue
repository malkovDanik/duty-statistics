<template>
    <el-card class="box-card">
        <subclass-chart :chartData="subclassChart" />
    </el-card>
</template>

<script src="./Graphs.ts" lang="ts"></script>

<style lang="scss" scoped>
.box-card {
    width: 100%;
    height: 100%;
    ::v-deep {
        .el-card__body {
            height: 100%;
            box-sizing: border-box;
        }
    }
}
</style>
