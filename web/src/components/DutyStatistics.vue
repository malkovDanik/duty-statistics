<template>
    <div>
        <section-top-panel />
        <div class="central-panel">
            <div style="display: flex; align-items: center">
                <span class="field-label">Период: </span>
                <el-date-picker
                    v-model="period"
                    format="dd.MM.yyyy HH:mm"
                    align="center"
                    end-placeholder="Дата окончания"
                    range-separator="по"
                    start-placeholder="Дата начала"
                    type="datetimerange"
                    unlink-panels
                    class="change-log-date-picker"
                    size="mini"
                    :picker-options="pickerOptions"
                    :clearable="false"
                >
                </el-date-picker>
            </div>
            <div style="display: flex; flex: 1; margin-top: 10px">
                <ships-table />
                <route-table style="margin-left: 20px" />
            </div>
            <graphs style="flex: 1; margin-top: 10px" />
        </div>
    </div>
</template>

<script src="./DutyStatistics.ts" lang="ts"></script>

<style lang="scss" scoped>
.field-label {
    font-size: 14px;
}
.central-panel {
    display: flex;
    flex-direction: column;
    box-sizing: border-box;
    height: calc(100% - 40px);
    padding: 7px;
}
</style>
