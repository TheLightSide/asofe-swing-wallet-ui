/************************************************************************************************
 *  _________          _     ____          _           __        __    _ _      _   _   _ ___
 * |__  / ___|__ _ ___| |__ / ___|_      _(_)_ __   __ \ \      / /_ _| | | ___| |_| | | |_ _|
 *   / / |   / _` / __| '_ \\___ \ \ /\ / / | '_ \ / _` \ \ /\ / / _` | | |/ _ \ __| | | || |
 *  / /| |__| (_| \__ \ | | |___) \ V  V /| | | | | (_| |\ V  V / (_| | | |  __/ |_| |_| || |
 * /____\____\__,_|___/_| |_|____/ \_/\_/ |_|_| |_|\__, | \_/\_/ \__,_|_|_|\___|\__|\___/|___|
 *                                                 |___/
 *
 * Copyright (c) 2016 Ivan Vaklinov <ivan@vaklinov.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 **********************************************************************************/
package com.vaklinov.zcashui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;


/**
 * Typical about box stuff...
 *
 * @author Ivan Vaklinov <ivan@vaklinov.com>
 */
public class AboutDialog
	extends JDialog
{
	public AboutDialog(JFrame parent)
		throws UnsupportedEncodingException
	{
		this.setTitle("About...");
		this.setSize(620, 440);
	    this.setLocation(100, 100);
		this.setLocationRelativeTo(parent);
		this.setModal(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JTabbedPane tabs = new JTabbedPane();

		JPanel licensePanel = new JPanel();
		licensePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		licensePanel.setLayout(new BorderLayout(3, 3));
		JLabel licenseLabel = new JLabel();
		licenseLabel.setText(
			"<html><body><pre>" +
		    " Copyright (c) 2018 The LightSide \n" +
		    " Copyright (c) 2016-2017 Ivan Vaklinov &lt;ivan@vaklinov.com&gt; \n" +
			"\n" +
			" Permission is hereby granted, free of charge, to any person obtaining a copy\n" +
			" of this software and associated documentation files (the \"Software\"), to deal\n" +
			" in the Software without restriction, including without limitation the rights\n" +
			" to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n" +
			" copies of the Software, and to permit persons to whom the Software is\n" +
			" furnished to do so, subject to the following conditions:\n" +
			" \n" +
			" The above copyright notice and this permission notice shall be included in\n" +
			" all copies or substantial portions of the Software.\n" +
			" \n" +
			" THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n" +
			" IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n" +
			" FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n" +
			" AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n" +
			" LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n" +
			" OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\n" +
			" THE SOFTWARE.		\n" +
			"</pre></body></html>");
		licenseLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		licensePanel.add(licenseLabel, BorderLayout.NORTH);

		tabs.add("License", licensePanel);

		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.getContentPane().add(tabs, BorderLayout.NORTH);

		JPanel closePanel = new JPanel();
		closePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		JButton closeButon = new JButton("Close");
		closePanel.add(closeButon);
		this.getContentPane().add(closePanel, BorderLayout.SOUTH);

		closeButon.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					AboutDialog.this.setVisible(false);
					AboutDialog.this.dispose();
				}
		});
		
		pack();
	}
}
