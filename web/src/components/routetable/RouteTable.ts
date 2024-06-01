import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class RouteTable extends Vue {
    @Prop({ default: (): [] => [] })
    private route: any[] = [];
}
