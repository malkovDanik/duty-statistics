<template>
    <el-card class="box-card">
        <div class="chart-container">
            <div :id="containerId" class="chart"></div>
        </div>
    </el-card>
</template>

<script lang="ts" src="./SubclassChart.ts" />

<style lang="scss" scoped>
.box-card {
    width: 20%;
    height: 100%;
    ::v-deep {
        .el-card__body {
            height: 100%;
            box-sizing: border-box;
            display: flex;
        }
    }
}
.chart-container {
    height: 100%;
    width: 100%;
    display: block;
}
.chart {
    height: 100%;
    width: 100%;
    ::v-deep {
        .anychart-credits {
            display: none;
        }
    }
}
</style>
