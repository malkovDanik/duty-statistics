/**
 * Аннотация для АПИ, определяющая её основной URL
 * @param url основной URL
 * @constructor
 */
export default function RequestUrl(url) {
    return function(constructor) {
        return class extends constructor {
            constructor() {
                super(...arguments);
                this.mainUrl = url;
            }
        };
    };
}
