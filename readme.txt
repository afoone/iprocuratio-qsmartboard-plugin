Плагин для предоставления данных в табло в виде war-плагина QSmartboard.

Этому плагину нужен файл конфигурации, из которого подтянутся некоторые настройки для главного табло.

Плагин и табло: QSmartboardPlugin.jar, qsmartboard.war
Положить, соответственно, в папку с плагинами и www/war:
    QSmartboardPlugin.jar -> <qsystem>/plugins
	qsmartboard.war -> <qsystem>/www/war

Нстройка плагинта: взять файлик QSmartboardPlugin.properties и отправить его в <qsystem>/config/. Можно там что-нибудь изменить, при желании.