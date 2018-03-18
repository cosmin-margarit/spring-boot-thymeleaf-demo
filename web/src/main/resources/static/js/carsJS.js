(function ($) {

    $(".confirm-car-delete").click(function () {
        href = $(this).data('href');
        if (confirm('Are you sure ?')) {
            location.href = href;
        }
    });

    $(document).ready(function () {
        console.log("ready!");
    });
})(jQuery);

