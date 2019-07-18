package practice;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileStream {
	public static void main(String[] args) {
		Path path = Paths.get("C:/");
		try {
			/* �����ļ���ض��� */
			WatchService watchService = FileSystems.getDefault().newWatchService();
			/* ע���ļ���ص������¼�����,register:ʹ���ֱ����ע���·�����ڵ��ļ���
		StandardWatchEventKinds:��׼�¼����� */
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			/* ѭ������ļ� */
			while (true) {
		                                    /* WatchKey �����ƣ�watchService.take()������Ϣ */
				WatchKey watchKey = watchService.take();
				/* ���������¼��������ļ� ,WatchEventһ���¼����ͣ�����ʶ��*/
				for (WatchEvent<?> event : watchKey.pollEvents())
					System.out.println(event.context().toString() + " �¼����ͣ�"
							+ event.kind());
		                                       /*���ô��ֱ��*/
				if (!watchKey.reset())
					return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
