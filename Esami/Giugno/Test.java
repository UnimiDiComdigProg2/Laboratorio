import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		CompanyAds company = new CompanyAds(args[0]);

		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci o aggiorna campagne:");

		while(s.hasNextLine()) {
			String[] cmd = s.nextLine().split(" ");
			AdCampaign tmp = null;

			if(cmd[2].equals("open")) {
				if(cmd[1].equals("Social"))
					tmp = new AdCampaignSocial(cmd[0]);
				else if(cmd[1].equals("WebRestyle"))
					tmp = new AdCampaignWebRestyle(cmd[0], Double.valueOf(cmd[3]));

				try {
					company.addCampaign(tmp);
				} catch (IllegalArgumentException | CampaignExistsException e) {
					System.out.println(e.getMessage());
					System.exit(1);
				}
			} else if(cmd[2].equals("close")) {
				tmp = company.getCampaign(cmd[0]);

				try {
					tmp.close();
				} catch (CampaignClosedException | NullPointerException e) {
					System.out.println(e.getMessage());
					System.exit(1);
				}
			} else if(cmd[2].equals("update")) {
				tmp = company.getCampaign(cmd[0]);

				try {
					if(cmd[1].equals("Social"))
						((AdCampaignSocial) tmp).update(Integer.valueOf(cmd[3]), Integer.valueOf(cmd[4]));
					else if(cmd[1].equals("WebRestyle"))
						((AdCampaignWebRestyle) tmp).update(Integer.valueOf(cmd[3]), Double.valueOf(cmd[4]));
				} catch (CampaignClosedException e) {
					System.out.println(e.getMessage());
					System.exit(1);
				}
			}
		}

		System.out.println(company);

		s.close();
	}
}