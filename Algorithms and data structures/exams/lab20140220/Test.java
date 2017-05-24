package lab20140220;

import java.util.Iterator;
import java.util.Random;

public class Test {
	private static final int UNRUNNABLE = 0;
	private static final int RUNNABLE = 1;
	private static final int STOPPED = 2;

	public static void main(String... args) {
		Random rnd = new Random();
		PQA<Process>[] queues = new PQA[3];
		
		queues[UNRUNNABLE] = new PQA<Process>();
		queues[RUNNABLE] = new PQA<Process>();
		queues[STOPPED] = new PQA<Process>();

		Process[] procs = { new Process("/init.d"), new Process("/kernel"),
				new Process("/usr/bin/vim"), new Process("/usr/bin/emacs"),
				new Process("/usr/bin/cat"),
				new Process("/home/simone/.rvm/ruby"),
				new Process("/usr/bin/perl"),
				new Process("/init.d/superdaemon"),
				new Process("/usr/proc/disdic.pl"),
				new Process("/usr/bin/ls"), new Process("/usr/local/bin/htop"),
				new Process("/usr/local/bin/scriptz.py"),
				new Process("/usr/bin/python"),
				new Process("/usr/bin/ciao.rb"),
				new Process("/usr/bin/tron.bas"), new Process("/usr/bin/MCP"),
				new Process("/etc/configurer.sh") };

		for (int i = 0; i < procs.length; i++) {
			queues[UNRUNNABLE].insert(procs[i], rnd.nextInt(101));
		}
		
		Iterator<Process> it = queues[UNRUNNABLE].iterator();
		
		System.out.println("Priority\tPID\tProcess");
		while(it.hasNext()) {
			Process elem = it.next();
			
			System.out.println(queues[UNRUNNABLE].getPriority(elem) + "\t" + elem.toString());
		}
		System.out.println("process: " + queues[UNRUNNABLE].size());
		
		// cambio lo stato dei processi
		
		for (int i = 0; i < 20; i++) {
			int rndStatus = rnd.nextInt(STOPPED + 1);
			
			if (!queues[rndStatus].isNew()) {
				try {
					// prendo il primo elemento della coda e lo elimino
					Process first = queues[rndStatus].first();
					int priority = queues[rndStatus].getPriority(first);
					queues[rndStatus].delFirst();
					
					// decido se cambiare di priorita'
					int cPrio = rnd.nextInt(10) + 1;
					if (cPrio <= 1)
						priority = rnd.nextInt(101);

					// scelgo le nuove priorità
					
					if (rndStatus == UNRUNNABLE) {
						queues[RUNNABLE].insert(first, priority);
					} else if (rndStatus == RUNNABLE) {
						//TODO METTERE O IN RUNNABLE ON IN STOPPED
						queues[STOPPED].insert(first, priority);
					} else if (rndStatus == STOPPED) {
						queues[RUNNABLE].insert(first, priority);
					}
				} catch (EccezioneStrutturaVuota e) {
					continue;
				}
			}
		}
		
		System.out.println("----- NEW STATUS -----");
		
		for (int i = 0; i < STOPPED + 1; i++) {
			
			switch(i) {
			case UNRUNNABLE:
				System.out.println("UNRUNNABLE: ");
			break;
			case RUNNABLE:
				System.out.println("RUNNABLE: ");
			break;
			case STOPPED:
				System.out.println("STOPPED: ");
			break;
			}
		
			it = queues[i].iterator();
			
			System.out.println("Priority\tPID\tProcess");
			while(it.hasNext()) {
				Process elem = it.next();
				
				System.out.println(queues[i].getPriority(elem) + "\t" + elem.toString());
			}
			System.out.println("process: " + queues[i].size());
		}

	}
}
