$(document).ready(function () {
    $('.ui.form').form({
        on: 'blur',
        inline: true,
        fields: {
            guestName: {
                identifier: 'guestName',
                rules: [{
                    type: 'empty',
                    prompt: '请填写姓名'
                }]
            },
            guestMobile: {
                identifier: 'guestMobile',
                rules: [{
                    type: 'regExp[/^1[3456789]\\d{9}$/]',
                    prompt: '请填写手机号'
                }]
            },
            startTime: {
                identifier: 'startTime',
                rules: [{
                    type: 'empty',
                    prompt: '日期不能为空'
                }]
            },
            endTime: {
                identifier: 'endTime',
                rules: [{
                    type: 'empty',
                    prompt: '日期不能为空'
                }]
            },
        }
    });


    $('select[name="roomCount"]').change(function () {
        var count = $(this).val();
        var price = $('#price').data('price') * count;
        $('#count').text(count);
        $('#price').text(toDecimal2(price));
    })


    $('input[name="endTime"]').blur(function () {
        //TODO 根据日期计算价格
    });

    $('.sub-btn').click(function () {
        $("form").submit();
    })
});

today = new Date;

$('.start_time').calendar({
    type: 'date',
    today: true,
    minDate:today,
    formatter: {
        date: function (date, settings) {
            if (!date) return '';
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            month = month < 10 ? '0' + month : month;
            day = day < 10 ? '0' + day : day;
            return year + '-' + month + '-' + day;
        }
    },
    text: {
        days: ['日', '一', '二', '三', '四', '五', '六'],
        today: '今天',
    },
});

$('.end_time').calendar({
    type: 'date',
    ampm: false,
    startCalendar: $('.start_time'),
    formatter: {
        date: function (date, settings) {
            if (!date) return '';
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            month = month < 10 ? '0' + month : month;
            day = day < 10 ? '0' + day : day;
            return year + '-' + month + '-' + day;
        }
    },
    text: {
        days: ['日', '一', '二', '三', '四', '五', '六'],
    },
});

function toDecimal2(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return false;
    }
    var f = Math.round(x * 100) / 100;
    var s = f.toString();
    var rs = s.indexOf('.');
    if (rs < 0) {
        rs = s.length;
        s += '.';
    }
    while (s.length <= rs + 2) {
        s += '0';
    }
    return s;
}

