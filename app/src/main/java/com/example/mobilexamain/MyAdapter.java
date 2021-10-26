package com.example.mobilexamain;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    String data1[], data2[], data3[], data4[], data5[],
            data6[], data7[], data8[], data9[], data10[];
    int photo[];
    Context context;

    public MyAdapter(Context ct, String strModel[], String strRelease[], String strLink[], String strCamera[], String strMemory[],
                     String strScreen[], String strPrice[], String strCpu[], String strGpu[], String strBattery[], int pht[]) {
        context = ct;
        data1 = strModel;
        data2 = strRelease;
        data3 = strLink;
        data4 = strCamera;
        data5 = strMemory;
        data6 = strScreen;
        data7 = strPrice;
        data8 = strCpu;
        data9 = strGpu;
        data10 = strBattery;
        photo = pht;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myText3.setText(data3[position]);
        holder.myText4.setText(data4[position]);
        holder.myText5.setText(data5[position]);
        holder.myText6.setText(data6[position]);
        holder.myText7.setText(data7[position]);
        holder.myText8.setText(data8[position]);
        holder.myText9.setText(data9[position]);
        holder.myText10.setText(data10[position]);
        holder.myImage.setImageResource(photo[position]);


    }

    @Override
    public int getItemCount() {

        return photo.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2, myText3, myText4, myText5,
                myText6, myText7, myText8, myText9, myText10;
        ImageView myImage;
        String strLink[]= context.getResources().getStringArray(R.array.link);

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.my_text1);
            myText2 = itemView.findViewById(R.id.my_text2);
            myText3 = itemView.findViewById(R.id.hyperLink1);
            myText4 = itemView.findViewById(R.id.my_text4);
            myText5 = itemView.findViewById(R.id.my_text5);
            myText6 = itemView.findViewById(R.id.my_text6);
            myText7 = itemView.findViewById(R.id.my_text7);
            myText8 = itemView.findViewById(R.id.my_text8);
            myText9 = itemView.findViewById(R.id.my_text9);
            myText10 = itemView.findViewById(R.id.my_text10);
            myImage = itemView.findViewById(R.id.myImageView);
            myText3.getAutoLinkMask();
            /*myText3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    for(int i=0;i<strLink.length;i++){


                        switch (strLink[i]) {

                            case "Apple_iPhone_11_Pro_Max":
                                Intent intentAdapter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Apple-iPhone-11-Pro-Max-64-256-512GB-Green-Space-Gray-Silver-Gold-GSM-Unlocked/193320142645?epid=4037673616&amp;hash=item2d02c74735%3Ag%3AONoAAOSw7FFeLyp2&amp;LH_BIN=1&amp;LH_ItemCondition=1000"));
                                context.startActivity(intentAdapter);
                                break;
                            case "Apple_iPad_Pro_11":
                                Intent intentAdapter2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Apple-iPhone-11-Pro-Max-64-256-512GB-Green-Space-Gray-Silver-Gold-GSM-Unlocked/193320142645?epid=4037673616&amp;hash=item2d02c74735%3Ag%3AONoAAOSw7FFeLyp2&amp;LH_BIN=1&amp;LH_ItemCondition=1000"));
                                context.startActivity(intentAdapter2);
                                break;
                            case "Apple_iPhone_8":
                                Intent intentAdapter3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Apple-iPhone-8-64GB-256GB-Unlocked-Smartphone-12M-WARRANTY-UK-Stock/193064785007?epid=239009722&amp;_trkparms=ispr%3D1&amp;hash=item2cf38ed46f%3Ag%3AZ9IAAOSwUshdYPy-&amp;enc=AQAFAAACcBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkfKe2vUidqHRg3XM2X2xOVIGcI16Basb4dxtS6zNS4mH1UTqFa%2BSlyDQwd4XFuZXnnV23s32Px%2BztvKIRHTLw3AM8tQKqISlCIA5gX6fxRkLgFe%2BC3YpD9GfQ0mD9T63EXYgQutMUxl7lwyfko2ubTDysaRlzpCl%2BJ8iA95aCwDfdzQGfm1k3t3ImTn8%2F7uyJ6uGx91K1Bs1N9fIfHQ6zPb2N7gRl9bJAUw3SUzxnkwDIojIJYiz7GUt%2Bg25KiYEJopgqaAA%2BPeZ1lW7b2PnoJa%2Fl%2BLG3NHgzVzAY0Fvv%2F4rUMVKj5gesepSM%2BjJLoSwKLg1kvNCdNuRPpLpJy0aXjzYWLUnEu73o844Vv3dxhPD5H0i%2BJj41BnKbVQ0DJi3PI421yQANoSx0YsRNhs7Q%2BECO0oJaEwW%2FOT%2FJHVZAb4sgshBfLPdNclxa5%2BPNHI2qX5DjIsAh%2Bn0ocPTT3vKfP6Nz%2B4qvevOcO1slWL2qjLDG6ktAivSVZQ722grHmIHS0r1wylNuJSP%2BUt5dPAHOQVopW%2BoBMF8ZNXNsYZ6GmuZpXw6zyo%2F7uOysKVLvkV9FZs5AlrFa8PPwQm%2BhwxGBamqa5VD0tK9aZGLzpp7eDAIdu9A8D4bcs4ZK9p4T%2BIaEoQDlae6Jysp0DD8GRYbA2eSG%2BhaY%2B7G4nitT3HWPdPchG67xrGcQeS9I20ECtH6xBTFM9rsvV%2B3%2FfR8%2FfUNVxUm%2FkjReI%2BTCaPD8pWwyslyLIRpwrzMGnXyTlWTNp1eBdHKA4zNrOM%2B5PJEZWCdD%2Bg%3D%3D&amp;checksum=1930647850078824ac157f8b4cc39104cb17be4a6b45&amp;LH_ItemCondition=3&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter3);
                                break;
                            case "Apple_iPhone_8_plus":
                                Intent intentAdapter4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Apple-iPhone-8-Plus-Gold-64GB-256GB-4G-LTE-Unlocked-Smartphone-SIM-Free/192942417934?hash=item2cec43a80e:g:4b0AAOSwiA9djGJY"));
                                context.startActivity(intentAdapter4);
                                break;
                            case "Apple iPhone se 2020":
                                Intent intentAdapter5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Apple-iPhone-SE-2nd-Gen-2020-128GB-FACTORY-UNLOCKED-Black-GSM-CDMA-SEALED/324306684095?epid=3037860076&amp;_trkparms=ispr%3D1&amp;hash=item4b822f48bf%3Ag%3AhBAAAOSwEUJfa%7Epg&amp;enc=AQAFAAACcBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickk5v8gVt3hEWLVg%2F253w6XCRknfVb1sdKnw5ihPbW2MhnUbAcr7%2F3lzobvLGU%2FtwvI%2BYpaKz9%2Foy%2BZqLiMxzeEVvKAFFcJ1Ky%2F1G%2F5x83nC42tP8mR6txgv0YpDW7%2F8YnVY%2FdKkcotKq4dJBu4zTXWcDLf93Hjp0eikNJn5wWK2tA2JdOwD4ni%2BsuLmetyWjsNu8GBKdlibLc7u%2Bi4TReBqBoiZUNJuymAb7XRv9XunMfF5kZmimNPu31oIUuqYfKkOpMe1K8SzpwvwMTycxqzWc8aoqx4uYIH13EfV%2FMgt97qro5uUu913%2BoyOOa59Re1PsmsHHoqHEXL8PIEeY%2FqMkSIp0InrrH%2Fx17S2ZrdhbcM84CEj7BP2Yv03QsW1oQ7ReH8A0waklKd3K%2FqVC5lynqHUg9f8UW9oMm48QJLcWAl%2BXbf%2FJTeb0%2BYeAT%2F8oIIe1PzZ631IcMjHJmGKEHpcuCQlb4TH2ea847r4BwSzRIvGEbNlIaFmEQC2YOmwJujPDdWmUHRnH8eleo0FKogb0X%2F6i3vsDv8fbo%2F1EKJZi%2FBhmKmrINaYKt4tVkW6ODexB3r2%2FMIbpQPBI4Arccw1gsAyrgYptcdsCAe1RVcGOzl8KJ7SM2V%2B2VvYYEDOunu3iCXelglgKP8GSr%2FN9EHm5iBrQnjtq8aVAnDwVBlPAQZTv8WLuJ5eyS8VPIyPYGE37iDTdUMrreTvGbzza6cMNwSCL%2BXcG1GLpMIitn%2BKXMqEbw7c8G4Lt02bnkdckkiZi6pEjBzwPwFhCv9Zs6tkQ%3D%3D&amp;checksum=324306684095260e2f9500b24540bc180b3fae9d973f&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter5);
                                break;
                            case "Apple_iPhone_x":
                                Intent intentAdapter6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Apple-iPhone-X-64GB-Silver-Verizon-T-Mobile-AT-T-GSM-Unlocked-Smartphone/332905566289?epid=238941171&amp;_trkparms=ispr%3D1&amp;hash=item4d82b7d051%3Ag%3AJWoAAOSwIulfUVHZ&amp;enc=AQAFAAACYBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkCrLl8erj3ATP5raQxjc%2F%2B2G7rOaSf1iBhZVFr6M8xi3Ttlv2oMD%2FViEaRfnlJ1nYq6xP4zIx%2B0bOYQrQyOc7UPO9Kb8GHvYJq7EEG%2BvVpKeTsDvN36oByQ6CUkm4fr8UkFOh1%2FMpHvH0EnpT3NBS7Wltyd0h5GZJnLYYOqbIihTVlQsJvqPP%2BIheisQisAVc7D2shVELGEE3FxG8hxCrJWF97tTssPlatAaLjP85J1PTuE9vznjf17LUta9uaygtcqujcMpCjySwRGfc8GoKUNoxWR3%2BaoFDAPLvhNAA1oa4wJa9EeZ%2Fd7wqF9ItJBMFe0B41IFZrwHuxIYxSlEnLcjBBjOcSeMpY%2FpTYm2P5J1OURcJKJaTmdvJZPrAX3JTrajAh%2FgoYveNmfH6rabRbuAQMTUQthtF9rbF2%2Bgr6FOJziww600QNpu5byWpj7HDuqqLOt5cOTbFmtO9DH%2FRtHXZ4TRSlg0b5ypHhYug7sRrRqpL6ZS8qwFVysJe%2FT8CDLDho2Y8ywd06iX49jrwXEkKJkLJf5e%2BFGaVblofhpUefjN6u%2B3l8e%2FbaIXrB%2FV7WxNRMquTytNBIX1Lwr0tekSJW%2FBZcXiOoFWZZdSfNd3RKeOoNAYnAJ9NzoSX9aXvFZJha4uXTBn9qO5bBSw2IFpOymu6H8Vg6QTPOg3pjgZ8aYHCZpDCq2qAxf8zLD%2BsyYf6wEzO20vd%2BaivJ15dWX%2Bm0hueU5O6FCzFSkhwN0Jo63kpjCbSpIM9ut3SClTY&amp;checksum=332905566289161c2c8ebb634310a62769b9d3f0a8ab&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter6);
                                break;
                            case "Huawei Mate 30 Pro 5G":
                                Intent intentAdapter7 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Huawei-Mate-30-Pro-5G-8-256GB-6-53-40-40-8MP-Kirin990-4500mAh-Phone-by-Fed-ex/323966132623?hash=item4b6de2e18f%3Ag%3A1-8AAOSwVl9djdSU&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter7);
                                break;
                            case "Huawei Mate xs":
                                Intent intentAdapter8 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Huawei-Mate-XS-512GB-8GB-RAM-TAH-N29m-Dual-Sim-FACTORY-UNLOCKED-8-0-40MP/223958954744?hash=item3424fe72f8%3Ag%3A80IAAOSwZDleflEi&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter8);
                                break;
                            case "Huawei_Nova_5t":
                                Intent intentAdapter9 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Huawei-nova-5T-15-9-cm-6-26-6-GB-128-GB-Dual-SIM-4G-USB-Type-C-Black-Android/193690057816?epid=26034093614&amp;hash=item2d18d3bc58:g:rVcAAOSwF5dfdK4Q"));
                                context.startActivity(intentAdapter9);
                                break;
                            case "Huawei_Nova_7i":
                                Intent intentAdapter10 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Huawei-Nova-7i-UNLOCKED-8GB-128GB-48MP-HiSilicon-Kirin-810/303598458412?_trkparms=ispr%3D1&amp;hash=item46afe0d62c:g:4QwAAOSw-Rle6X8p&amp;enc=AQAFAAACcBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkpFtSR0CGv%2Bh98r8Yb9quS6JkdsxqhHEJthbSSMAFxiGxy1oYHZCjKlCD4OKqzHJU9Cdg6FPx6shdLVM9xgonBNWvqeBOT7ok3yUVbjeTrTMyAZZfsTonV%2FMM%2B44vfFCQZwJPJ7zQliIJv8FkCjvdkDFMZ65UgK2s1mWFN4Auwdzft5pBjdsd%2F7TdLamigC2h4lqDdARro8rCOqMUVe3QnsN87SuAVxUIjBJ8z6rGyzEUhCpqShjxqmxZNTUExxqpbTo%2BxYk2Nnx3nkD2kZRGdbuDcDM1EwvYlfRUNbNNn5e7%2FMV52wKZxi6qssO3avC71Nz7M3GPrDC4NASPglX57psjwwNg8RpyALI5whgxm79LLFK2ChptcnkWolmotOS2fF9qLEwCX5GoK8YydTLAygWf%2FOD9uNB4a%2BeQVfYMeCt7BS6S4IUGOKPt57WsHmOwjlSrNZW4boSWqL9%2FZ5i7aGgNHUIEa2EbUwS7IzWgSRjhdD%2Frcv5PkwIwp0PMV2zR7f%2F3M4N%2BFAhTNk3SNUUNHajI%2FnMwYAQS5o29DBxnySuVULhnLcWS2o0uxm%2BhHR9SZQBnHvp3ls7a3Oe5sWdKsXPShj%2BJXgQzV7uVpIIstx2krCwDq0jTZcGBJbryB4gtKW9LzyMwdP4YDOATyeCc5SJYSS6ZqC1xVL5d6vL%2FWp0XHW9zSOyGsW9FJCkVH78nlShMoWZKrHSJIGWTDL%2BVIaUzG2vzvZG6e9kxy09XhP%2BBRlYy5TiunHJikp2TmqF5CoAO0TBNzNelT17s3WvEpQ%3D%3D&amp;checksum=3035984584127377badf85474fe780633f2ac74d1b6a"));
                                context.startActivity(intentAdapter10);
                                break;
                            case "Huawei p20 30 Pro":
                                Intent intentAdapter11 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Huawei-P20-Pro-Black-6-1-128GB-4G-Unlocked-SIM-Free-51092HYB/132625797475?epid=14025957812&amp;_trkparms=ispr%3D1&amp;hash=item1ee11d1163%3Ag%3AEOQAAOSwNndcwvUy&amp;amdata=enc%3AAQAFAAACcBaobrjLl8XobRIiIML1V4Imu%252Fn%252BzU5L90Z278x5ickkBUIiHwYv5YgVss0WaiENz6QEfmNpwGRvB1oSNItb%252Bp9J22orhk3oR4iIeLdAxTtSLqfDtqV9NdvLsSpBtw%252BvqaZBO%252BgkbDS1psJa4hi6OCDhFUg3XEXu8jhjZjGGD8TRMyiPWGU3lSkHPV%252FMOAVQW%252FgudqvArhFikAYP%252F8n8BR4Tx2pVaswmWU9BPEKqc57aVdIRKBXp72dXGA2uvyhQElPJ0dtPC0PVQXoTYbidagbIYQLAF%252FPMizpJvOxdLx%252BZamIGKsO8rOZJxOJhQHwzp3lFnEpjS%252BdvSzT8BuJA7j05cJx5osR1%252FX%252BflwyXnI3Bp1XUJS3UOgvqlF%252FY9cuFFgr9Uyh058YCIeuPq5pswFL9%252FGiPFMsUg6d4c6pMuGc3%252B%252BW6xlxTN3YbwaWBjRXXt5tn7braGsyY6xC%252B%252FCcDcXYaMUxAFQ2kAftFsS2M4Xz6DXiX20luiaRWKi%252FlqkiHspL5ZcE9bMwOgrPEd%252Bcu9siqH4IDkH8x309fuy00Jut9XIT7tVh9vH7WudkF1O0SINdi4d82ItzgffATqw45OfAFnPAhGWKM9lwh5G6JJ1MCuF%252BtnPLc3PdGgEck3WfjikQ%252B3t6k4F8c36VnGvFvoB3spk5VRo2D68tm57JRpey7Y4xtyCk4TnAepbtB5R3TUvyXxXq7l6UW%252BXalvdGrrle9L1j9zZDqSB5tmaMwSdoFQK830PBx%252B50HOYE%252FPDOYcZfcRV3LQL6Tw39aGnLQZrIy8bsu%252FaxQ9sRC1W5c3FQHEmeRltfKfXUuNsu0oOdTFQ%253D%253D%7Ccksum%3A13262579747522064a35633d4ae490565910a0898755%7Campid%3APL_CLK%7Cclp%3A2334524&amp;LH_ItemCondition=1000"));
                                context.startActivity(intentAdapter11);
                                break;
                            case "Huawei p40 30 Pro":
                                Intent intentAdapter12 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Huawei-P40-Pro-Plus-5G-UNLOCKED-8GB-512GB-6-58-Kirin-990-Car-Super-Charger/303649259135?_trkparms=ispr%3D1&amp;hash=item46b2e7fe7f%3Ag%3A5bMAAOSwzVxfJo-n&amp;enc=AQAFAAACcBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkpFtSR0CGv%2Bh98r8Yb9quS5t7hIYkEXqbNMoBNSlqE9os%2Ftqc3C0vpPSTIaBSR2yWThtXt%2FzTJkFEUvvHFAKdE791pIpB5PC%2FFqprEGNCcVcV4oKEkopHm56eYgj7vQuUMvuhODOM3YBShjDWHjQQQCkcjWTzGKaApy88I8NJHtv0299apPwZPZ0HkM3CITpdohyybnjP5g4v%2BkQjH8awWkOVoo4G89McfmRMhoTtlm7DRPfKbYRDZzVs%2BN3FikgAwevIkq3JCw2BSjbaWmTNf9iB1OERfWIX%2F3NZ2Pu77%2BHwmll64IfHIxBhhT9Grfy4OlXTftzSm8w5OEw5dd3rstAwbqi%2BLMxZ5d9ehq8nDaYurLFB82HVzkH9dn57U18xVli0QlPQ9lxh2VjLzAx1dfHRPZJl1I4BJNkeqXIFUcw5mCkLk%2B6xH9u%2FoF4t%2B0eQc5QjSFn2nlBjQhXnGU%2Bwxkgabn6j9bmeFbbup0c5TXGio9k0SCUJCQquKM56QnYPOGZdoEA%2BTciknrVGiP7SAOUC5%2By44ksOGkkzb1lWt2pHjE3OUk26RYe%2FTYK4TieBHJteyd1LTcznLWaHoUcQXzCcFjQgNrAL6Qj14jNCMlbCmFU7KvWfF39WdMMNOMd8QbB%2BugLlc7p%2F3fGaqR9SSsLBoY6kwBPU6vEg8vHGr4Skco2qpqbUgHPYgQEUudj2DhTWWCEJEB1wat454I6PFH26X01ZgQVy7ONGyEVD42D8U0X41c96BNlEyxx6KRd1u7%2Bvw%2BJT9AeIOTbpKHGGJA%3D%3D&amp;checksum=303649259135d7c497d642b84fb1b2d17d0b980a5468&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter12);
                                break;
                            case "LG G8 ThinQ":
                                Intent intentAdapter13 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/LG-G8-ThinQ-128GB-Gray-Sprint-GSM-Unlocked-Brand-New-Inbox/164380477796?_trkparms=ispr%3D1&amp;hash=item2645d70964%3Ag%3A-cAAAOSwBANfXMcl&amp;enc=AQAFAAACYBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkfOCvCjTOBWK8pwriaolq5kZV%2B5AEXYSdHRiNdOYTNDUUnjWWYOmJxjuWGPvfq%2FDbZbtyHeUBoIX12fsr5NjUB%2BT8sBcmsxLsA982jImKXfV6TrupvaDsDr1mL%2Bu4jcqFVBfahOZ54FcJmeqQMe16G2qeYYLpBkM0IUJgTkmovfwVbSPiRcFWS%2BU20IeP7ARIBlIF%2Fo%2B8jx4Y44mWNEgExSI9xkexh13ZPygQbcolTM3rk5eTq2Iq2t6%2BbpxbFuwQAUx3fBptEIZ5aXjBAX69Te1YCGiy9HA%2FxKN47%2BxkUUxZuZsHP5Rid95w0wHiLYLYt5LMUefZIdoTcGdGreYQD0Tqq%2FL5r63Y4aCHlgJCjgWJb60XmbRn%2BLpmpJLHSarh4TMDdf9ZLTnqOJak304Nzt7%2Fj6mM5l1ecuxoGZ%2FV3qqlvoxQyOVYyszsBQmNnNXO%2FlefA0ZcptOtkOwp63G83szs%2FmbqP1%2FpqsG0b%2BBpLEhbliaxBu5eEv9U5sAvJ90GUICKUnNKlhu1WYEtJ9wIb5v5Ye%2B8r2flfSDxLRmUqhAEcG6HmjhKXFJ9gqSDcTIE2pw5S0%2B5ybO3Rl3lxEF2DHjz7m48gE%2FWbWY%2FRjNj6XmysLUbQSUB0u2CGPmGxnA7UpLjPg5I98IgC%2FBChQitephtQlzg1Fu3ZVBv12TN6Bpbe5VBWD8hbWNa8rFJ528Yf8tynKpf74R1kLEGaNLTqFUQX3w1IvhTSkBKviWqvPkr5T2HIt8yILD8ZEwlmC%2BJ&amp;checksum=164380477796e7423024ccfd48ebb6419ce3838e017b&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter13);
                                break;
                            case "LG_K30_2019":
                                Intent intentAdapter14 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/LG-K30-2019-16GB-Smartphone-Unlocked-Black-LMX320QMG-AUSABKY/313030189719?epid=10034673698&amp;_trkparms=ispr%3D1&amp;hash=item48e20da297%3Ag%3AIXkAAOSwXepeb%7Ek0&amp;enc=AQAFAAACYBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkRjLZq23gAR%2BKma9gM2Z1htclsnJrH4VnNJrW4H%2BL8k5r4gh2ERlrRCxYQRO0Red%2F6B5hcVqjnUjRQglK2%2BziLQKXFNhIvawnjNdoWakLsMhd1SBKPMnaJcNPtyg6911%2FLGF5TOzoRgC%2BNxQLh1pkiyjowBl8%2FuiXEv2IBSPgdncPUNCZDB%2BPvB4losZICOOH7FX4cSl%2Bfzf6IP2428c6Blp6wWmbU7RJdpWdJTu69OY6N2UvJxMIqMICbtzQKmnZ0Ny2EKPxb10LAmVAkZkXYki%2FbjdA7vteyW9p41iarnWieIjpmpdEFIb2AI2ZUlaFLV96Wq3ECxE0P8XOQF7UmzVoce3ZnRmxeMDX1VpAZ88dwfQGdAEFhojTQ%2Byi%2F%2Bd5lPMZ%2F5uVawY829y%2BUsnWys6r08AstOSqj0fNqNjnB%2BFiWHIW1yFrp4ak%2Fm%2FU2El1AjZ9F%2FVFYIIpkceF4brr%2B1A7kjFlE9UWvHss3kmUPlOFxr1IBuoPVcaL1C6MDsrOzmfefjBnqJvhuccNwT9ToZ%2FWY8JbQQaasLwW8VWEYgs0TWj53pooqOxjhjfwN6OCzF5JRku03G7s%2Fk4GgcBJ1EN2KFwGo0deyu9g7nGowRvlnM5fpapdPpzHiqRuA%2BxWcC8ARERxDHVpkxkisquFpsQjIdOIOD6FMWRdwh%2BSR2%2B5ZxlvJ7XTlexFBcVvTlPkAgMQeX%2B%2F1oPJd80XK%2B92DzIC%2Fq8%2FtXilyLHdaPvjZUPPyVvC0OB9j0s2eYoapcTe&amp;checksum=3130301897194f553e8454444cafbf839e9a6d5b12ca&amp;LH_BIN=1&amp;LH_ItemCondition=1000"));
                                context.startActivity(intentAdapter14);
                                break;
                            case "LG_Q92_5G":
                                Intent intentAdapter15 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/LG-Q92-5G-LM-Q920N-Unlocked-Smartphone-6-7-6GB-128GB/264872368712?hash=item3dab9f9a48%3Ag%3A%7E-oAAOSw-3NfaBN%7E&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter15);
                                break;
                            case "LG V30 ThinQ":
                                Intent intentAdapter16 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/LG-V30-H932-Dual-Camera-4G-LTE-64GB-Silver-T-Mobile-Brand-New-Retail-Pack/163503227608?epid=241149937&amp;_trkparms=ispr%3D1&amp;hash=item26118d42d8%3Ag%3AjNcAAOSwvFJdl3Bp&amp;enc=AQAFAAACYBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkfOCvCjTOBWK8pwriaolq5psP6qrvKvkahgJV%2FtzjWmgqG1Iqsew3SX0RtJVjCQ4E1oU4fOO4uzPo4pm6DLUNbngUNQRus7CvaOkqYouA1hH5TudEKDz8o8eo42kHrCDUdEVGamLa6sHXRqBNHMQ9vxaJPFpxc%2FlcjcRs9g%2BuPCU5EaesE16JeOFjDYbaGqOY5876QkIXg3QqVDHcZ5oNXSUrvAhcTDqycbw%2Bc%2FI%2ByLWZQg%2F7qql%2FSV8I4UjBt43nzgIHC9v4fatnqbw2tQiE5gnB1RFwuG8hRimTza82G%2BxMrZ8UY07cviRaN6zSzPix6fPjFlcGdC5wQq4uq%2Bl%2F3d6d8HgXEba4%2F3akR5f8%2FW2uCKpylz%2FtFKKeScwtKwg9P1wqfb1IHU8zgeWwx%2FlpjDjL4eACCeoCfW4OKAEDHebeYS1Dj%2BijKpYaNbfaKatcXJDUYroWLW8D1RcInuare8GZaV6NiDK3XQd%2FHWtCXGuE1F0okqRlk6%2FBxllCbB%2FArUxRB5vnrDvXDOTGHjwUECpf6DRtVF2zNzXgG3FDs3lPC8u5c%2BYvOYc4pIZAnwJ5nUGYwd0GRVP9dcEMjJwRcJ1mmG5UuBzHeDfVunqHwTtIMDIPHTcrDZdZf%2FDp5oMr4NCWnpM6W3oUvxdgV%2BRuw5%2BlEXD5NLCvKp%2F6QzdpC%2F%2BOdGM4vaBw9KB76fFWaK9vNWqF4wrA2jv5gk%2FiCMITieKUtzpBlO5cXnpafsIGSycy08aHcazabGVmEiQBs1m3&amp;checksum=16350322760828503e6c2b164ae4b2439431065b29b7&amp;LH_BIN=1&amp;LH_ItemCondition=1000"));
                                context.startActivity(intentAdapter16);
                                break;
                            case "LG V50 ThinQ 5G":
                                Intent intentAdapter17 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Brand-New-LG-V50-5G-ThinQ-128GB-Aurora-Black-Sprint-CDMA-GSM-Unlocked/383566191190?epid=25032320771&amp;hash=item594e539a56%3Ag%3ACBMAAOSwocFe0CAq&amp;LH_ItemCondition=1000"));
                                context.startActivity(intentAdapter17);
                                break;
                            case "LG_Velvet":
                                Intent intentAdapter18 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/LG-Velvet-with-Dual-Screen-LM-G900N-6-8-4G-5G-Factory-Unlocked-8GB-128GB/333620502099?hash=item4dad54de53%3Ag%3AG3UAAOSwOWlfKO5j&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter18);
                                break;
                            case "Samsung_Galaxy_M51":
                                Intent intentAdapter19 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Samsung-Galaxy-M51-128GB-6GB-RAM-64-8-5-5-Camera-Dual-Sim-7000mAH-NFC-Phone/174441042152?hash=item289d7f10e8%3Ag%3AUowAAOSwTzpfZFbx&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter19);
                                break;
                            case "Samsung_Galaxy_Note10_5g":
                                Intent intentAdapter20 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Samsung-Galaxy-Note-10-256GB-Dual-Sim-New-Unlocked/143473720645?epid=21034129824&amp;_trkparms=ispr%3D1&amp;hash=item2167b33d45%3Ag%3AKUQAAOSwMXxfWMyu&amp;enc=AQAFAAACcBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickk7d4nremBkvNKtcC0ZwqXDD4tvzZYXB8zQFoRAaYMB5VG%2F62%2BekCd%2F6hxEqbNLgRaZxwlux8IxWq6oxVN5bxTVbWVAkIVHygqfkV%2FhbM51twt5FUccRgHGMKu6oFi%2FR1qppgS%2B77MWQckz%2BpIyzcY2RxJmGfoK6DAH2EWP9Gi%2BMaanF3UeTNdiDKEgqx5VZ6cOaCpPefrFEOAtpbAaNDkhGMCqd1JjQEzX71n0pATmuU9cWFi15pHXx469vSXaGF1f3InzlAVjW0YTsk67dRlfVlqnWYfGpmkZqLo0ZRBT36VkPlLABdJO6%2Bif1l%2BHZjgx4%2F1IIXSZfK1Chfn%2Fi8MA3dr%2BPCt%2BB6FvjO%2FRsrNXd92JPaCyR1t4LnYzAvO3nKMyQIcL2X7GYvze6YEETDh6JN5R9CZYM4c15k34gfdE6BhwdbZE6f1TecTHesd75x9ebkl%2FahkvByLfWjusTM3e6SSQPH3JVdOaYQbvp0BuMvRC83I%2BuQdMyt4xORc5CSrQ8RK7CAdanwgvW9LI42xrzsfLG93F2sn50nAb5QblkUQ32NE0w2uqqV3X1e3JsQM6RKSalXl9oTG60dzANN8LV5BpTaT61ZCT7%2BHwMVQqKYpuNZSCnj53tgAYvudQ42UmvTsHyNUrlbhGxwkvziVrpnsEWYVfx5y3X5o8apGxRelSwBl1s0JO18snnwVd6M1e2wEyJHQ%2Bm%2Bu4t7gV66o3GEcRsIY44m%2B4810FljFoll8HQawv0oG%2FNztulU0sLuku1VtFbcJ0CnWRAInXZ9BSQ%3D%3D&amp;checksum=143473720645d576c805395741608df5bfd91077c032&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter20);
                                break;
                            case "Samsung Galaxy Note20 Ultra":
                                Intent intentAdapter21 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Samsung-Galaxy-Note-20-Ultra-256GB-12GB-RAM-SM-N9860-FACTORY-UNLOCKED-6-9/203076143230?hash=item2f4848087e%3Ag%3A9VYAAOSweENfLZZz&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter21);
                                break;
                            case "Samsung Galaxy S20":
                                Intent intentAdapter22 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Samsung-Galaxy-S20-Plus-SM-G985F-DS-128GB-8GB-RAM-FACTORY-UNLOCKED-6-7-64MP/202905303442?epid=27037171664&amp;hash=item2f3e193992%3Ag%3AiGEAAOSwz2BeRtrX&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter22);
                                break;
                            case "Samsung_Galaxy_Tab_S6_Lite":
                                Intent intentAdapter23 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Samsung-Galaxy-Tab-S6-Lite-with-S-Pen-SM-P610-64GB-4GB-10-4-Wi-Fi-Only-NO-LTE/293660126943?hash=item445f81eedf%3Ag%3ADCwAAOSwZH1fGjQz&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter23);
                                break;
                            case "Samsung Galaxy Z Flip 5G":
                                Intent intentAdapter24 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Samsung-Galaxy-Z-Flip-5G-Unlocked-SM-F707-8GB-256GB-2020-New-3-Color/224147956914?hash=item34304264b2%3Ag%3AEmEAAOSwmNFfWGIp&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter24);
                                break;
                            case "Sony_Xperia_1":
                                Intent intentAdapter25 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/New-SEALED-Sony-Xperia-1-128GB-Unlocked-Black-J8170-USA-US-Version/254722104399?hash=item3b4e9edc4f%3Ag%3A51cAAOSwCaBfZDW4&amp;LH_BIN=1&amp;LH_ItemCondition=1000"));
                                context.startActivity(intentAdapter25);
                                break;
                            case "Sony_Xperia_10":
                                Intent intentAdapter26 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Sony-XPERIA-10-II-XQ-AU52-128GB-4GB-RAM-FACTORY-UNLOCKED-6-0-Snapdragon-665/193476009323?hash=item2d0c119d6b%3Ag%3Aiz0AAOSwR3lezqTd&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter26);
                                break;
                            case "Sony_Xperia_10 II":
                                Intent intentAdapter27 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.co.uk/Sony-Xperia-Android-Smartphone-Resistance/dp/B089WJR9P8"));
                                context.startActivity(intentAdapter27);
                                break;
                            case "Sony Xperia 1 II":
                                Intent intentAdapter28 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Sony-XPERIA-1-II-XQ-AT52-256GB-8GB-RAM-Dual-SIM-FACTORY-UNLOCKED-6-5/224037884660?hash=item3429b2d2f4%3Ag%3AWj8AAOSwrk5e3Tgt&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter28);
                                break;
                            case "Sony Xperia 5 II":
                                Intent intentAdapter29 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Sony-XPERIA-5-II-SO-52A-256GB-8GB-RAM-FACTORY-UNLOCKED-6-1-Snapdragon-865/224166740154?hash=item34316100ba%3Ag%3AHusAAOSwzV5famC9&amp;LH_ItemCondition=1000&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter29);
                                break;
                            case "Sony Xperia L4":
                                Intent intentAdapter30 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/NEW-Sony-Mobile-Xperia-L4-64-Gb-Smartphone-15-7-Cm-6-2-Lcd-Hd-1680-X-720-3-Gb/402413482976?_trkparms=ispr%3D1&amp;hash=item5db1b673e0%3Ag%3Ah6MAAOSw7lxfU5Rp&amp;enc=AQAFAAACcBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkTboA95HSvGa1O5UmCCGJLiVitQuqkPWPJ0OaJ9EW%2FA6q0i3kN0kmD2nP7QsLBNNlY%2FZhlkrjI6drIH7fX6%2F6yMjaBG4yCxJWP60jWGrABQ5chuwmyeaica%2BZXRGJKom7X1qh0x14EJxrnpUWqP1h24u9Z380wLI70Mkb7CmuTX%2Fi%2FAZ6OQxL%2B06eEH8EsQfubPNN3n52vqZJIImjA6T%2BzfDg23TZaV4DZvMt4pTM7KahvWY1Mqv7yKSCOEgTiRoJBBsB4YCR9Hm1lkh1JiGfY5CP%2BGtsKfprX7or%2FLqavMKWjHTig1XTWdcyt1yZVX%2BgRkXR0RBM7eLf%2Bx9EbkKSrmnFfMAinCSMGZ2Gx7IqpN93fxLKPWea23AgmfDfm4IeYXQPt7j05TB8kT44DyVtRTRj8bNWZS3X8UOr8VEtHolMIXP2FluEL10hQhGzYJcCdY5C4d9zt%2FlQnPWBp4NwXrqezy5qEh7qgD7dzKyd2joc2HouxZOG3p6jAAni3IqXHJbo4cFO8U%2Fat08TDtwnm4ooqTzIcnj%2B3%2FyhE6EbMy2A5WVPVr5mJzyxqeecBO8mtV5Iw2zgcu%2FC74Qo%2FdBtfLIFezbOT0lA94ZtBjItigcLN81a9a2w7Fvpt7u0rOa1%2BbqaCZXbO0uS6dccQsY0AXXwVmHQsfyHKmoTzTAVb1GJLrWnWUKXunSuAtylsilDFJgQ%2Bzw7T93PFzu8I0L42RIsVkZYHH%2FIDEVHdJuqt9Pixs%2BkqX8pHElmxLYw7MslVDMJiQ1g2zaomD2gsl3RSw%3D%3D&amp;checksum=40241348297682597d299f36428a80b6e62ce80f939a&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter30);
                                break;
                            case "Xiaomi Poco F2 Pro":
                                Intent intentAdapter31 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Xiaomi-Poco-F2-Pro-256GB-8GB-RAM-FACTORY-UNLOCKED-6-67-64MP-Global/202998940317?hash=item2f43ae029d%3Ag%3ANmIAAOSwMkRevs4m&amp;LH_BIN=1&amp;LH_ItemCondition=1000"));
                                context.startActivity(intentAdapter31);
                                break;
                            case "Xiaomi Poco X3":
                                Intent intentAdapter32 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Xiaomi-Poco-X3-128GB-6GB-RAM-FACTORY-UNLOCKED-6-67-64MP-Global/303695646998?_trkparms=ispr%3D1&amp;hash=item46b5abd116%3Ag%3AFJUAAOSwgJdfZLkx&amp;enc=AQAFAAACYBaobrjLl8XobRIiIML1V4Imu%2Fn%2BzU5L90Z278x5ickkpFtSR0CGv%2Bh98r8Yb9quS8N1wpCdemmwGa%2BKHhybeZfFwUAfHMgQ3yatpix3ks%2Br1RvC6WUVOXxUX%2FcLmRor8s32y7zdKCF1uN1mcry8nWCXuFCWm3KYOzjBgDHHgv9TmZlbyARKeT%2FqfSNOKS8r916PdWglyrt3Q57pN30%2BdGnstYid7EtydzKnBSNnm76xBaDjMXO%2FLHa26FTfJnZGGPD3jPGDeTEwybdrTU2%2BsT5e1YVUoIY6VyhjxzWKm4EBlqV5VCIAPEMiR7gzdP0ddP8nmpBsA9p1mGPqKfAYsiOhgWFUUaEt621lkBIYEEW6ieBv4JmXLQRi93IE1hCxHocJzNFxaIjusgZ6HAFS4f9QmaafEcE%2FPoijnaWxvPfbCgcSH%2F2W7%2BlgJuwsvWUCmRUWmfPb9jR4eGUUkRMXnOs0oUTzEYxJNv7TYRoudwFK6unN%2FJ3ofkgIVy%2BlqtknXSiGDLAIMZJm%2BN%2FaQ%2F0RuhEP5fNMyR1EqwixtjFV6NRTEbb%2BJdVGfHV8NvfMDhIGkH%2Bvm47c71yX5FCVRCq5iDORRrRlRl8VnuUDZ4RJIdCnMmlWwJ3gwqiln6F1cI5v1E9pbZi2vMo6ToUru98rvyPzau3b0J4hjEtzgrTF6uGDp3lVVC3bkuO3auZN%2BIZ6PFcPa9Iu7Y5FwcERaQnbPVVoblXiJY2lY7bA5nUGgezKxTq3D90TxJoWF8SrEoh3L28bY7J4t9B2PIS%2B2DKV5Tmeh6byCnQk7gc%2BxwSUz13N&amp;checksum=30369564699878701ac9dfad4da994a4bc45ec3c0c2f&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter32);
                                break;
                            case "Xiaomi Poco X3 NFC":
                                Intent intentAdapter33 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Xiaomi-Poco-X3-NFC-64GB-6GB-RAM-FACTORY-UNLOCKED-6-67-64MP-Global/203117786395?hash=item2f4ac3751b%3Ag%3AfCUAAOSwyKBfW8mU&amp;LH_ItemCondition=3&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter33);
                                break;
                            case "Xiaomi Redmi 9a":
                                Intent intentAdapter34 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Xiaomi-Redmi-9A-32GB-Dual-SIM-FACTORY-UNLOCKED-6-53-5000-mAh-Global/203049699948?hash=item2f46b48a6c%3Ag%3AcsAAAOSw3yJfEHg6&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter34);
                                break;
                            case "Xiaomi Redmi K30 Ultra":
                                Intent intentAdapter35 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Xiaomi-Redmi-K30-Ultra-128GB-6GB-6-67-64-13-5-2MP-Octa-core-Phone-By-FedEx/333695268452?hash=item4db1c9b664%3Ag%3AU-YAAOSww-VfP2NF&amp;LH_ItemCondition=3&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter35);
                                break;
                            case "Xiaomi Redmi Note 9 Pro":
                                Intent intentAdapter36 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/itm/Xiaomi-Redmi-Note-9-Pro-64GB-6GB-RAM-FACTORY-UNLOCKED-6-67-64MP-Global/303589440710?hash=item46af573cc6%3Ag%3AZD0AAOSwsrhe2QeD&amp;LH_BIN=1"));
                                context.startActivity(intentAdapter36);
                                break;
                        }

                    }
                }
            });*/
        }

    }
}

