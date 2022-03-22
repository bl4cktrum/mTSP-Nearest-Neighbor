package edu.anadolu;

class TurkishNetwork {
    static final String[] cities = new String[]{"ADANA", "ADIYAMAN", "AFYON", "AĞRI", "AMASYA", "ANKARA", "ANTALYA", "ARTVİN", "AYDIN", "BALIKESİR", "BİLECİK", "BİNGÖL", "BİTLİS", "BOLU", "BURDUR", "BURSA", "ÇANAKKALE", "ÇANKIRI", "ÇORUM", "DENİZLİ", "DİYARBAKIR", "EDİRNE", "ELAZIĞ", "ERZİNCAN", "ERZURUM", "ESKİŞEHİR", "GAZİANTEP", "GİRESUN", "GÜMÜŞHANE", "HAKKARİ", "HATAY", "ISPARTA", "İÇEL", "İSTANBUL", "İZMİR", "KARS", "KASTAMONU", "KAYSERİ", "KIRKLARELİ", "KIRŞEHİR", "KOCAELİ", "KONYA", "KÜTAHYA", "MALATYA", "MANİSA", "KAHRAMANMARAŞ", "MARDİN", "MUĞLA", "MUŞ", "NEVŞEHİR", "NİĞDE", "ORDU", "RİZE", "SAKARYA", "SAMSUN", "SİİRT", "SİNOP", "SİVAS", "TEKİRDAĞ", "TOKAT", "TRABZON", "TUNCELİ", "ŞANLIURFA", "UŞAK", "VAN", "YOZGAT", "ZONGULDAK", "AKSARAY", "BAYBURT", "KARAMAN", "KIRIKKALE", "BATMAN", "ŞIRNAK", "BARTIN", "ARDAHAN", "IĞDIR", "YALOVA", "KARABÜK", "KİLİS", "OSMANİYE", "DÜZCE"};
    static final int[][] distance = new int[][]{{0, 335, 575, 966, 603, 567, 535, 1035, 874, 903, 773, 636, 732, 690, 646, 842, 1094, 577, 581, 755, 525, 1178, 494, 670, 809, 690, 212, 720, 778, 898, 191, 617, 69, 948, 901, 1014, 683, 335, 1159, 377, 837, 358, 675, 396, 885, 192, 537, 846, 743, 289, 207, 707, 919, 800, 719, 707, 845, 422, 1079, 491, 844, 628, 349, 690, 893, 489, 765, 267, 800, 292, 477, 621, 709, 782, 1042, 1066, 899, 714, 246, 87, 735}, {335, 0, 910, 648, 632, 814, 870, 751, 1209, 1238, 1040, 348, 414, 931, 981, 1109, 1380, 766, 696, 1090, 207, 1423, 285, 550, 525, 957, 150, 710, 683, 660, 316, 952, 404, 1193, 1236, 730, 872, 419, 1404, 553, 1082, 693, 1010, 187, 1220, 163, 299, 1181, 459, 500, 542, 724, 784, 1045, 748, 389, 888, 412, 1324, 520, 783, 419, 112, 1025, 575, 616, 1006, 575, 650, 627, 666, 303, 471, 1023, 758, 748, 1147, 955, 210, 248, 976}, {575, 910, 0, 1318, 597, 300, 290, 1243, 345, 328, 212, 1095, 1285, 420, 169, 277, 519, 397, 505, 222, 1100, 684, 953, 948, 1138, 144, 787, 871, 1015, 1473, 766, 168, 565, 454, 326, 1340, 503, 521, 665, 426, 343, 223, 100, 855, 310, 767, 1112, 367, 1202, 440, 459, 827, 1082, 306, 677, 1282, 675, 703, 585, 643, 1007, 1079, 924, 115, 1418, 479, 488, 365, 1037, 336, 339, 1196, 1284, 515, 1351, 1461, 338, 447, 821, 662, 375}, {966, 648, 1318, 0, 738, 1141, 1428, 396, 1640, 1569, 1361, 356, 234, 1147, 1423, 1418, 1689, 986, 830, 1517, 441, 1639, 496, 370, 183, 1295, 754, 545, 383, 425, 947, 1373, 1035, 1409, 1640, 216, 992, 812, 1620, 942, 1298, 1114, 1373, 592, 1624, 811, 519, 1662, 245, 891, 938, 589, 439, 1261, 739, 330, 894, 618, 1540, 675, 476, 423, 617, 1429, 228, 842, 1206, 966, 305, 1114, 979, 369, 430, 1175, 310, 143, 1363, 1106, 814, 879, 1192}, {603, 632, 597, 736, 0, 413, 825, 695, 938, 831, 623, 643, 833, 409, 762, 680, 951, 248, 92, 815, 696, 901, 543, 368, 558, 574, 579, 323, 435, 1133, 676, 719, 639, 671, 919, 760, 254, 346, 882, 312, 560, 511, 652, 463, 903, 503, 792, 960, 750, 361, 439, 279, 534, 523, 131, 882, 258, 220, 802, 114, 459, 499, 716, 708, 966, 200, 468, 422, 457, 615, 258, 796, 982, 437, 783, 881, 625, 368, 639, 608, 454}, {492, 742, 256, 1054, 333, 0, 542, 979, 597, 536, 316, 892, 1082, 191, 421, 385, 656, 130, 241, 474, 901, 683, 750, 684, 874, 233, 650, 607, 751, 1336, 683, 420, 485, 453, 578, 1076, 236, 318, 664, 184, 342, 258, 311, 652, 562, 574, 975, 619, 999, 275, 347, 563, 818, 305, 413, 1087, 408, 439, 584, 379, 743, 815, 787, 367, 1215, 215, 266, 225, 773, 369, 75, 1001, 1147, 283, 1087, 1197, 407, 215, 710, 579, 236}, {535, 870, 291, 1428, 825, 543, 0, 1466, 339, 507, 474, 1171, 1267, 682, 121, 539, 695, 667, 733, 220, 1060, 903, 1029, 1058, 1248, 422, 747, 1099, 1166, 1433, 726, 130, 466, 716, 444, 1450, 773, 618, 920, 572, 605, 322, 362, 931, 428, 727, 1072, 311, 1278, 537, 544, 1055, 1307, 568, 905, 1242, 945, 810, 847, 871, 1232, 1163, 884, 293, 1428, 684, 750, 462, 1188, 374, 567, 1156, 1244, 801, 1473, 1571, 600, 733, 781, 622, 637}, {1035, 751, 1243, 396, 693, 979, 1466, 0, 1584, 1460, 1252, 403, 560, 1038, 1408, 1309, 1580, 894, 738, 1461, 544, 1530, 543, 408, 226, 1220, 857, 372, 336, 758, 1016, 1365, 1104, 1300, 1565, 207, 856, 850, 1511, 949, 1189, 1152, 1298, 639, 1549, 863, 640, 1606, 477, 929, 976, 416, 161, 1152, 566, 656, 721, 656, 1431, 632, 236, 461, 720, 1354, 561, 837, 1070, 1004, 343, 1152, 904, 597, 756, 1039, 116, 341, 1254, 970, 917, 948, 1083}, {874, 1209, 345, 1640, 938, 597, 339, 1584, 0, 296, 520, 1404, 1594, 716, 269, 445, 451, 738, 846, 126, 1399, 659, 1262, 1270, 1460, 477, 1086, 1212, 1356, 1772, 1065, 288, 805, 684, 126, 1662, 844, 830, 676, 767, 573, 532, 408, 1164, 155, 1066, 1411, 99, 1511, 749, 768, 1168, 1423, 602, 1018, 1581, 1016, 1022, 630, 984, 1348, 1396, 1223, 273, 1727, 820, 784, 674, 1378, 641, 680, 1495, 1583, 856, 1685, 1783, 510, 788, 1120, 961, 671}, {903, 1238, 328, 1567, 831, 536, 507, 1460, 296, 0, 246, 1414, 1604, 422, 395, 151, 191, 655, 774, 287, 1423, 399, 1272, 1199, 1389, 303, 1115, 1088, 1250, 1801, 1094, 394, 893, 390, 176, 1591, 667, 840, 416, 706, 279, 551, 228, 1174, 141, 1095, 1440, 394, 1521, 768, 787, 1044, 1299, 308, 894, 1609, 839, 983, 370, 923, 1224, 1330, 1252, 223, 1737, 759, 490, 693, 1288, 664, 619, 1523, 1612, 577, 1568, 1712, 216, 556, 1149, 990, 377}, {773, 1045, 212, 1358, 622, 316, 475, 1251, 520, 245, 0, 1194, 1384, 212, 353, 94, 365, 445, 564, 397, 1203, 476, 1052, 989, 1179, 83, 952, 878, 1040, 1638, 964, 352, 763, 246, 419, 1381, 457, 620, 457, 486, 135, 421, 112, 954, 384, 876, 1277, 542, 1301, 577, 648, 834, 1089, 98, 684, 1389, 629, 763, 377, 703, 1014, 1120, 1089, 251, 1517, 539, 280, 526, 1078, 534, 399, 1303, 1449, 367, 1358, 1502, 126, 346, 1012, 860, 167}, {636, 348, 1095, 356, 641, 892, 1171, 403, 1404, 1414, 1194, 0, 194, 1052, 1187, 1264, 1535, 891, 735, 1281, 141, 1544, 144, 275, 177, 1112, 454, 542, 380, 494, 617, 1137, 705, 1314, 1421, 382, 897, 574, 1525, 708, 1203, 878, 1190, 240, 1405, 464, 237, 1426, 111, 655, 702, 586, 436, 1166, 720, 280, 865, 467, 1445, 575, 473, 144, 317, 1210, 327, 691, 1111, 730, 302, 878, 821, 194, 380, 1080, 410, 499, 1268, 1011, 514, 549, 1097}, {732, 414, 1285, 234, 831, 1082, 1267, 562, 1594, 1604, 1384, 194, 0, 1242, 1377, 1454, 1725, 1081, 925, 1471, 207, 1734, 334, 465, 347, 1302, 520, 709, 547, 328, 713, 1327, 801, 1504, 1611, 432, 1087, 764, 1715, 898, 1393, 1068, 1380, 430, 1595, 577, 285, 1578, 83, 845, 892, 753, 603, 1356, 903, 96, 1055, 657, 1635, 765, 640, 334, 383, 1400, 161, 881, 1301, 920, 469, 1024, 1011, 135, 196, 1270, 492, 334, 1458, 1201, 580, 645, 1287}, {690, 936, 420, 1145, 409, 191, 683, 1038, 716, 422, 213, 1050, 1240, 0, 561, 271, 542, 233, 352, 605, 1095, 492, 944, 777, 967, 291, 844, 666, 828, 1530, 881, 560, 683, 262, 596, 1169, 245, 512, 473, 378, 151, 456, 320, 846, 561, 768, 1169, 750, 1159, 469, 545, 622, 877, 114, 472, 1281, 417, 627, 393, 521, 802, 908, 981, 459, 1375, 409, 157, 423, 866, 567, 269, 1195, 1341, 174, 1146, 1290, 216, 134, 904, 777, 45}, {657, 992, 169, 1423, 762, 421, 122, 1408, 269, 395, 353, 1187, 1377, 561, 0, 418, 586, 562, 670, 150, 1171, 794, 1045, 1053, 1243, 301, 858, 1036, 1161, 1544, 837, 51, 577, 595, 374, 1445, 668, 613, 806, 566, 484, 314, 241, 947, 358, 838, 1183, 241, 1294, 532, 551, 992, 1247, 447, 842, 1353, 840, 805, 726, 808, 1172, 1179, 995, 172, 1510, 644, 629, 457, 1183, 419, 504, 1267, 1355, 680, 1468, 1566, 479, 612, 892, 733, 516}, {842, 1114, 277, 1416, 680, 385, 540, 1309, 445, 151, 94, 1264, 1454, 271, 418, 0, 271, 504, 623, 436, 1272, 419, 1121, 1048, 1238, 152, 1021, 937, 1099, 1707, 1033, 417, 832, 243, 325, 1440, 516, 689, 436, 555, 132, 490, 177, 1023, 290, 945, 1346, 543, 1370, 646, 717, 893, 1148, 157, 743, 1458, 688, 832, 374, 772, 1073, 1179, 1158, 305, 1586, 608, 339, 595, 1137, 603, 468, 1372, 1518, 426, 1417, 1561, 69, 405, 1081, 929, 226}, {1101, 1385, 526, 1687, 951, 656, 702, 1580, 451, 198, 365, 1535, 1725, 542, 593, 271, 0, 775, 894, 475, 1543, 216, 1392, 1319, 1509, 423, 1292, 1208, 1370, 1978, 1285, 585, 1084, 318, 327, 1711, 787, 960, 233, 826, 399, 742, 419, 1294, 329, 1216, 1617, 549, 1641, 917, 978, 1164, 1419, 428, 1014, 1729, 959, 1103, 187, 1043, 1344, 1450, 1429, 414, 1857, 879, 610, 866, 1408, 855, 739, 1643, 1789, 697, 1688, 1832, 336, 676, 1340, 1181, 497}, {577, 771, 397, 984, 248, 130, 667, 894, 738, 655, 446, 889, 1079, 233, 562, 504, 775, 0, 156, 615, 916, 725, 763, 616, 806, 374, 679, 522, 683, 1365, 768, 561, 570, 495, 719, 1008, 106, 347, 706, 213, 384, 353, 452, 681, 703, 603, 1004, 760, 998, 304, 386, 478, 733, 347, 328, 1102, 278, 440, 626, 334, 658, 747, 816, 508, 1214, 244, 293, 310, 705, 464, 104, 1016, 1176, 282, 1002, 1129, 449, 193, 739, 664, 278}, {581, 696, 505, 828, 92, 241, 733, 738, 846, 774, 565, 733, 923, 352, 670, 623, 894, 156, 0, 723, 760, 844, 607, 460, 650, 482, 613, 366, 527, 1225, 710, 627, 574, 614, 827, 852, 197, 281, 825, 220, 503, 419, 560, 527, 811, 537, 856, 868, 842, 296, 374, 322, 577, 466, 172, 946, 264, 284, 745, 178, 502, 591, 750, 616, 1058, 108, 411, 330, 549, 530, 166, 860, 1046, 380, 846, 973, 568, 311, 673, 642, 397}, {755, 1090, 222, 1517, 815, 474, 220, 1461, 126, 287, 397, 1281, 1471, 605, 150, 436, 482, 615, 723, 0, 1280, 683, 1139, 1147, 1337, 354, 967, 1089, 1233, 1653, 946, 165, 686, 639, 224, 1539, 721, 707, 700, 644, 528, 409, 285, 1041, 208, 947, 1292, 145, 1388, 626, 645, 1045, 1300, 491, 895, 1462, 893, 899, 654, 861, 1225, 1273, 1104, 150, 1604, 697, 673, 551, 1255, 518, 557, 1376, 1464, 733, 1562, 1660, 501, 665, 1001, 842, 560}, {525, 207, 1100, 441, 696, 901, 1060, 544, 1399, 1423, 1203, 141, 207, 1095, 1182, 1272, 1543, 916, 760, 1280, 0, 1587, 153, 408, 318, 1121, 313, 683, 521, 475, 506, 1142, 594, 1357, 1426, 523, 948, 583, 1568, 717, 1246, 883, 1199, 249, 1410, 370, 96, 1371, 252, 664, 711, 727, 577, 1209, 812, 186, 952, 476, 1488, 584, 614, 277, 176, 1215, 368, 700, 1162, 739, 443, 817, 830, 100, 286, 1131, 551, 541, 1311, 1062, 373, 438, 1140}, {1178, 1428, 684, 1637, 901, 683, 910, 1530, 659, 406, 477, 1542, 1732, 492, 801, 419, 216, 725, 844, 690, 1587, 0, 1436, 1269, 1459, 555, 1336, 1158, 1320, 2022, 1369, 793, 1171, 230, 535, 1661, 737, 1004, 63, 870, 341, 893, 584, 1338, 537, 1260, 1661, 757, 1651, 961, 1033, 1114, 1369, 378, 964, 1773, 909, 1119, 138, 1013, 1294, 1400, 1473, 622, 1867, 901, 560, 911, 1358, 1006, 761, 1687, 1833, 647, 1638, 1782, 406, 626, 1396, 1265, 447}, {494, 285, 953, 496, 543, 750, 1029, 543, 1262, 1272, 1052, 144, 334, 944, 1045, 1121, 1392, 763, 607, 1139, 153, 1436, 0, 267, 317, 970, 342, 562, 400, 628, 475, 995, 563, 1206, 1279, 522, 795, 432, 1417, 566, 1095, 736, 1048, 98, 1263, 322, 249, 1284, 251, 513, 560, 590, 575, 1058, 659, 339, 799, 323, 1337, 431, 500, 136, 319, 1068, 467, 547, 1009, 588, 396, 736, 679, 253, 439, 978, 550, 639, 1160, 909, 402, 407, 989}, {670, 550, 948, 370, 366, 684, 1058, 408, 1270, 1197, 988, 275, 465, 775, 1053, 1046, 1317, 614, 458, 1147, 408, 1267, 267, 0, 190, 925, 607, 295, 133, 765, 740, 1003, 739, 1039, 1270, 392, 622, 442, 1250, 572, 928, 744, 1003, 363, 1254, 570, 504, 1292, 382, 521, 568, 323, 308, 891, 445, 555, 590, 248, 1170, 305, 233, 131, 574, 1059, 598, 472, 836, 596, 155, 744, 609, 469, 655, 805, 415, 513, 993, 736, 667, 672, 822}, {809, 525, 1138, 183, 556, 874, 1248, 226, 1460, 1387, 1178, 177, 349, 965, 1243, 1236, 1507, 804, 648, 1337, 318, 1457, 317, 190, 0, 1115, 631, 365, 203, 608, 790, 1193, 878, 1229, 1460, 205, 812, 632, 1440, 762, 1118, 934, 1193, 413, 1444, 637, 414, 1482, 264, 711, 758, 409, 259, 1081, 559, 443, 714, 438, 1360, 495, 296, 243, 494, 1249, 411, 662, 1026, 786, 125, 934, 799, 371, 543, 995, 233, 326, 1183, 926, 691, 722, 1012}, {690, 962, 144, 1295, 574, 233, 423, 1220, 477, 303, 83, 1112, 1302, 291, 301, 152, 423, 374, 482, 354, 1121, 555, 970, 925, 1115, 0, 869, 848, 992, 1555, 881, 300, 680, 325, 410, 1317, 480, 537, 536, 403, 214, 338, 78, 871, 394, 793, 1194, 499, 1218, 494, 565, 804, 1059, 177, 654, 1306, 652, 680, 456, 620, 984, 1056, 1006, 217, 1434, 456, 359, 443, 1014, 451, 316, 1220, 1366, 446, 1328, 1438, 209, 424, 929, 777, 246}, {212, 150, 787, 754, 584, 655, 747, 857, 1086, 1115, 957, 454, 520, 849, 869, 1026, 1297, 684, 618, 967, 313, 1341, 342, 607, 631, 874, 0, 696, 740, 686, 193, 829, 281, 1106, 1113, 836, 785, 332, 1317, 466, 995, 570, 887, 244, 1097, 76, 325, 1058, 565, 413, 419, 683, 890, 958, 695, 495, 835, 398, 1237, 467, 820, 476, 137, 902, 681, 529, 919, 479, 736, 504, 579, 409, 497, 936, 864, 854, 1060, 868, 64, 125, 889}, {720, 710, 871, 545, 321, 607, 1099, 372, 1212, 1088, 879, 542, 711, 666, 1036, 937, 1208, 522, 366, 1089, 683, 1158, 562, 295, 365, 848, 701, 0, 162, 970, 793, 993, 789, 928, 1193, 567, 484, 492, 1139, 577, 817, 785, 926, 541, 1177, 620, 779, 1234, 626, 571, 618, 44, 211, 780, 194, 805, 349, 298, 1059, 260, 136, 426, 794, 982, 773, 465, 698, 646, 240, 794, 532, 736, 905, 667, 480, 688, 882, 598, 756, 725, 711}, {778, 683, 1015, 383, 433, 751, 1166, 336, 1356, 1250, 1041, 380, 549, 828, 1161, 1099, 1370, 681, 525, 1233, 521, 1320, 400, 133, 203, 992, 740, 162, 0, 808, 851, 1111, 847, 1090, 1337, 405, 646, 550, 1301, 680, 979, 852, 1070, 496, 1321, 678, 617, 1378, 464, 629, 676, 206, 175, 942, 356, 643, 511, 356, 1221, 372, 100, 264, 697, 1126, 611, 577, 860, 704, 78, 852, 676, 574, 743, 829, 428, 526, 1044, 760, 800, 783, 873}, {898, 660, 1473, 425, 1131, 1341, 1433, 761, 1772, 1801, 1643, 494, 328, 1535, 1555, 1712, 1983, 1370, 1223, 1653, 475, 2027, 628, 765, 608, 1560, 686, 970, 808, 0, 879, 1515, 967, 1792, 1799, 557, 1387, 1018, 2003, 1152, 1681, 1256, 1573, 724, 1783, 762, 387, 1744, 383, 1099, 1105, 1014, 864, 1644, 1164, 289, 1319, 951, 1923, 1059, 901, 634, 549, 1588, 197, 1175, 1601, 1165, 730, 1190, 1265, 375, 189, 1570, 645, 417, 1746, 1501, 746, 811, 1575}, {191, 316, 766, 947, 681, 683, 726, 1016, 1065, 1094, 964, 617, 713, 881, 848, 1033, 1292, 768, 715, 946, 506, 1369, 475, 740, 790, 881, 193, 798, 856, 879, 0, 808, 260, 1139, 1092, 995, 874, 429, 1350, 563, 1028, 549, 866, 377, 1076, 173, 518, 1037, 724, 480, 398, 780, 992, 991, 792, 688, 932, 495, 1270, 564, 917, 609, 330, 881, 874, 626, 956, 458, 869, 483, 668, 602, 690, 973, 1023, 1047, 1090, 905, 145, 129, 926}, {617, 952, 168, 1373, 719, 420, 130, 1365, 288, 394, 352, 1137, 1327, 560, 51, 417, 592, 561, 627, 165, 1142, 800, 995, 1003, 1193, 300, 829, 993, 1111, 1515, 808, 0, 564, 594, 382, 1395, 667, 563, 805, 516, 483, 263, 240, 897, 366, 809, 1154, 292, 1244, 482, 501, 949, 1204, 446, 799, 1324, 839, 755, 725, 765, 1129, 1129, 966, 171, 1460, 600, 628, 407, 1133, 368, 461, 1238, 1326, 679, 1418, 1516, 478, 611, 863, 704, 515}, {69, 404, 565, 1035, 639, 485, 466, 1104, 805, 893, 763, 705, 801, 683, 588, 832, 1091, 570, 574, 686, 594, 1171, 563, 739, 878, 680, 281, 789, 847, 967, 260, 564, 0, 941, 891, 1083, 676, 328, 1152, 370, 830, 348, 665, 465, 875, 261, 606, 777, 812, 282, 200, 776, 988, 793, 746, 776, 838, 491, 1072, 560, 913, 697, 418, 680, 962, 482, 758, 260, 869, 235, 470, 690, 778, 775, 1111, 1135, 889, 707, 315, 156, 728}, {948, 1198, 454, 1407, 671, 453, 717, 1300, 684, 390, 247, 1312, 1502, 262, 595, 243, 318, 495, 614, 639, 1357, 230, 1206, 1037, 1227, 325, 1111, 928, 1090, 1797, 1139, 594, 941, 0, 564, 1431, 507, 774, 211, 640, 111, 663, 354, 1108, 529, 1030, 1431, 782, 1421, 731, 803, 884, 1139, 148, 734, 1543, 679, 889, 131, 783, 1064, 1170, 1243, 493, 1637, 671, 330, 681, 1128, 776, 531, 1457, 1603, 417, 1408, 1552, 176, 396, 1166, 1035, 217}, {901, 1236, 326, 1640, 919, 578, 444, 1565, 126, 176, 419, 1421, 1611, 596, 374, 325, 327, 719, 827, 224, 1426, 535, 1279, 1270, 1460, 410, 1113, 1193, 1337, 1799, 1092, 382, 891, 564, 0, 1662, 825, 847, 552, 748, 453, 549, 332, 1181, 35, 1093, 1438, 224, 1528, 766, 785, 1149, 1404, 482, 999, 1608, 997, 1025, 506, 965, 1329, 1401, 1250, 211, 1744, 801, 664, 691, 1359, 662, 661, 1522, 1610, 751, 1673, 1783, 390, 730, 1147, 988, 551}, {1012, 728, 1338, 214, 756, 1074, 1448, 207, 1660, 1587, 1378, 380, 432, 1165, 1443, 1436, 1707, 1004, 848, 1537, 521, 1657, 520, 390, 203, 1315, 834, 565, 403, 560, 993, 1393, 1081, 1427, 1660, 0, 1014, 834, 1642, 964, 1320, 1136, 1395, 618, 1646, 842, 619, 1684, 349, 913, 960, 611, 360, 1283, 761, 528, 916, 640, 1562, 697, 435, 445, 699, 1451, 360, 864, 1228, 988, 327, 1136, 1001, 567, 628, 1197, 94, 140, 1385, 1128, 896, 927, 1214}, {683, 877, 503, 990, 254, 236, 773, 856, 844, 667, 458, 895, 1085, 245, 668, 516, 787, 106, 197, 721, 950, 737, 797, 620, 810, 480, 790, 484, 646, 1385, 874, 667, 676, 507, 825, 1010, 0, 453, 718, 319, 396, 459, 558, 715, 806, 709, 1044, 866, 1004, 410, 492, 440, 695, 359, 290, 1134, 183, 472, 638, 366, 620, 753, 922, 614, 1220, 301, 214, 416, 711, 570, 210, 1048, 1234, 183, 964, 1135, 461, 114, 845, 770, 290}, {335, 424, 521, 812, 346, 318, 618, 850, 830, 840, 620, 574, 764, 512, 613, 689, 960, 347, 281, 707, 583, 1004, 432, 442, 632, 537, 337, 492, 550, 1023, 434, 563, 328, 774, 847, 832, 453, 0, 985, 134, 663, 304, 616, 334, 831, 256, 657, 852, 681, 81, 128, 479, 691, 626, 453, 769, 545, 194, 905, 263, 616, 566, 469, 636, 897, 197, 587, 156, 572, 304, 247, 683, 829, 604, 857, 955, 728, 536, 392, 361, 557}, {1159, 1409, 665, 1618, 882, 664, 927, 1511, 676, 423, 458, 1523, 1713, 473, 806, 436, 233, 706, 825, 707, 1568, 62, 1417, 1248, 1438, 536, 1322, 1139, 1301, 2008, 1350, 805, 1152, 211, 552, 1638, 718, 985, 0, 851, 322, 874, 565, 1319, 554, 1241, 1642, 774, 1632, 942, 1014, 1095, 1350, 359, 945, 1754, 890, 1100, 119, 994, 1275, 1381, 1454, 639, 1848, 882, 541, 892, 1339, 987, 742, 1668, 1814, 628, 1619, 1763, 387, 607, 1377, 1246, 428}, {377, 558, 426, 942, 312, 184, 572, 949, 767, 706, 486, 708, 898, 378, 566, 555, 826, 213, 220, 644, 717, 870, 566, 572, 762, 403, 471, 577, 680, 1157, 568, 516, 370, 640, 748, 962, 319, 134, 851, 0, 529, 258, 482, 468, 733, 390, 791, 790, 815, 91, 173, 533, 788, 492, 392, 903, 484, 324, 771, 317, 713, 700, 603, 538, 1031, 112, 453, 110, 702, 321, 113, 817, 963, 470, 987, 1085, 594, 402, 526, 464, 423}, {837, 1087, 343, 1296, 560, 342, 606, 1189, 573, 279, 136, 1201, 1391, 151, 484, 132, 399, 384, 503, 528, 1246, 341, 1095, 926, 1116, 214, 1000, 817, 979, 1686, 1028, 483, 830, 111, 453, 1316, 396, 663, 322, 529, 0, 552, 243, 997, 418, 919, 1320, 671, 1310, 620, 692, 773, 1028, 37, 623, 1432, 568, 778, 242, 672, 953, 1059, 1132, 382, 1526, 560, 219, 570, 1017, 665, 420, 1346, 1492, 306, 1297, 1441, 65, 285, 1055, 924, 106}, {358, 693, 223, 1114, 511, 258, 322, 1152, 532, 551, 421, 878, 1068, 456, 314, 490, 749, 353, 419, 409, 883, 893, 736, 744, 934, 338, 570, 785, 852, 1256, 549, 263, 348, 663, 549, 1134, 459, 304, 874, 258, 552, 0, 323, 638, 533, 550, 895, 554, 985, 223, 242, 741, 993, 515, 591, 1065, 631, 496, 794, 557, 918, 870, 707, 338, 1201, 370, 531, 148, 874, 119, 253, 979, 1067, 548, 1159, 1257, 547, 480, 604, 445, 501}, {675, 1010, 100, 1373, 652, 311, 363, 1298, 408, 228, 112, 1190, 1380, 320, 241, 177, 426, 452, 560, 285, 1199, 584, 1048, 1003, 1193, 78, 887, 926, 1070, 1573, 866, 240, 665, 354, 332, 1393, 558, 616, 565, 482, 243, 323, 0, 949, 316, 867, 1212, 430, 1296, 540, 559, 882, 1137, 206, 732, 1382, 730, 758, 485, 698, 1062, 1134, 1024, 139, 1512, 534, 388, 465, 1092, 436, 394, 1296, 1384, 475, 1406, 1516, 238, 454, 921, 762, 275}, {396, 187, 855, 592, 463, 652, 931, 639, 1164, 1174, 954, 240, 430, 846, 947, 1023, 1294, 681, 527, 1041, 249, 1338, 98, 363, 413, 871, 244, 541, 496, 724, 377, 897, 465, 1108, 1181, 616, 717, 334, 1319, 468, 997, 638, 949, 0, 1165, 224, 345, 1186, 347, 415, 462, 555, 671, 960, 579, 435, 719, 243, 1239, 351, 596, 232, 271, 970, 563, 467, 921, 490, 492, 638, 581, 349, 535, 898, 646, 735, 1062, 829, 304, 309, 891}, {885, 1220, 310, 1624, 903, 562, 428, 1549, 155, 141, 384, 1405, 1595, 561, 358, 290, 330, 703, 811, 208, 1410, 538, 1263, 1254, 1444, 394, 1097, 1177, 1321, 1783, 1076, 366, 875, 529, 35, 1644, 806, 831, 555, 733, 418, 533, 316, 1165, 0, 1077, 1422, 253, 1512, 750, 769, 1133, 1388, 447, 983, 1592, 978, 1009, 508, 949, 1313, 1385, 1234, 195, 1728, 785, 629, 675, 1343, 646, 645, 1506, 1594, 716, 1657, 1767, 355, 695, 1131, 972, 516}, {192, 163, 767, 811, 508, 579, 727, 863, 1066, 1095, 881, 464, 577, 773, 849, 950, 1221, 608, 542, 947, 370, 1265, 322, 575, 637, 798, 76, 625, 683, 762, 173, 809, 261, 1035, 1093, 840, 714, 261, 1246, 395, 924, 550, 867, 224, 1077, 0, 401, 1038, 571, 337, 384, 607, 819, 882, 619, 552, 759, 322, 1161, 391, 744, 456, 213, 882, 738, 453, 843, 412, 700, 484, 503, 466, 573, 860, 870, 911, 984, 792, 136, 105, 813}, {537, 299, 1112, 519, 792, 980, 1072, 640, 1411, 1440, 1282, 237, 285, 1174, 1194, 1351, 1622, 1009, 856, 1292, 96, 1666, 249, 504, 414, 1199, 325, 779, 617, 386, 518, 1154, 606, 1436, 1438, 617, 1046, 662, 1647, 796, 1325, 895, 1212, 345, 1422, 401, 0, 1383, 348, 738, 744, 823, 673, 1283, 908, 230, 1048, 572, 1562, 680, 710, 373, 188, 1227, 446, 796, 1244, 804, 539, 829, 904, 150, 198, 1227, 647, 619, 1385, 1158, 385, 450, 1214}, {846, 1181, 367, 1662, 960, 619, 311, 1606, 99, 394, 542, 1426, 1578, 750, 241, 543, 549, 760, 868, 145, 1371, 757, 1284, 1292, 1482, 499, 1058, 1234, 1378, 1744, 1037, 292, 777, 782, 224, 1682, 866, 852, 774, 790, 671, 554, 430, 1186, 253, 1038, 1383, 0, 1533, 771, 790, 1190, 1445, 636, 1040, 1553, 1038, 1044, 728, 1006, 1370, 1418, 1195, 295, 1739, 842, 818, 696, 1400, 660, 702, 1467, 1555, 878, 1707, 1805, 608, 810, 1092, 933, 705}, {743, 459, 1202, 245, 748, 999, 1278, 479, 1511, 1521, 1301, 111, 83, 1157, 1294, 1370, 1641, 996, 840, 1388, 252, 1649, 251, 382, 266, 1218, 565, 628, 466, 383, 724, 1244, 812, 1419, 1528, 349, 1002, 681, 1630, 815, 1308, 985, 1296, 347, 1512, 571, 348, 1533, 0, 762, 809, 670, 520, 1273, 820, 179, 972, 574, 1552, 682, 557, 251, 428, 1317, 216, 798, 1218, 837, 386, 985, 928, 218, 279, 1187, 409, 388, 1375, 1118, 625, 656, 1204}, {289, 505, 440, 891, 361, 275, 537, 929, 749, 768, 577, 655, 845, 469, 532, 646, 917, 304, 296, 626, 664, 961, 513, 521, 711, 494, 418, 571, 629, 1104, 480, 482, 282, 731, 766, 911, 410, 81, 942, 91, 620, 223, 540, 415, 750, 342, 743, 771, 762, 0, 82, 553, 770, 583, 468, 850, 560, 273, 862, 337, 695, 647, 550, 555, 978, 203, 544, 75, 651, 258, 204, 764, 910, 561, 936, 1034, 685, 493, 473, 376, 514}, {207, 542, 459, 938, 439, 347, 544, 976, 768, 787, 648, 702, 892, 545, 551, 717, 985, 386, 374, 645, 711, 1033, 560, 568, 758, 565, 419, 618, 676, 1105, 398, 501, 200, 803, 785, 958, 492, 128, 1014, 173, 692, 242, 559, 462, 769, 389, 744, 790, 809, 82, 0, 605, 817, 655, 546, 897, 638, 320, 934, 389, 742, 694, 556, 574, 1025, 285, 620, 122, 698, 176, 286, 811, 916, 637, 983, 1081, 757, 569, 453, 294, 590}, {707, 726, 827, 589, 277, 563, 1055, 416, 1168, 1044, 835, 586, 755, 622, 992, 893, 1164, 478, 322, 1045, 727, 1114, 592, 325, 409, 804, 688, 44, 206, 1014, 785, 949, 776, 884, 1149, 609, 440, 479, 1095, 533, 773, 741, 882, 557, 1133, 612, 823, 1190, 672, 553, 605, 0, 255, 736, 150, 849, 305, 312, 1015, 216, 180, 454, 808, 938, 817, 421, 654, 628, 284, 781, 488, 780, 949, 623, 524, 732, 838, 554, 743, 712, 667}, {919, 784, 1082, 439, 532, 818, 1307, 161, 1423, 1299, 1090, 436, 605, 877, 1247, 1148, 1419, 733, 577, 1300, 577, 1369, 575, 308, 259, 1059, 890, 211, 175, 864, 997, 1204, 988, 1139, 1404, 360, 695, 691, 1350, 788, 1028, 993, 1137, 671, 1388, 824, 673, 1445, 522, 770, 817, 255, 0, 991, 405, 699, 560, 497, 1270, 471, 75, 439, 753, 1193, 667, 676, 909, 845, 253, 993, 743, 630, 799, 878, 269, 494, 1093, 809, 950, 924, 922}, {800, 1050, 306, 1259, 523, 305, 569, 1152, 602, 308, 99, 1164, 1354, 114, 447, 157, 428, 347, 466, 491, 1209, 378, 1058, 889, 1079, 177, 963, 780, 942, 1649, 991, 446, 793, 148, 482, 1279, 359, 626, 359, 492, 37, 515, 206, 960, 447, 887, 1288, 636, 1271, 583, 655, 736, 991, 0, 586, 1395, 531, 741, 279, 635, 916, 1022, 1095, 345, 1489, 523, 182, 533, 980, 628, 383, 1309, 1455, 269, 1260, 1404, 102, 248, 1018, 887, 69}, {720, 749, 677, 739, 131, 413, 905, 566, 1018, 894, 685, 721, 905, 472, 842, 743, 1014, 328, 172, 895, 813, 964, 660, 446, 559, 654, 701, 194, 356, 1164, 798, 799, 746, 734, 999, 759, 290, 453, 945, 392, 623, 591, 732, 580, 983, 625, 909, 1040, 822, 468, 546, 150, 405, 586, 0, 998, 155, 336, 865, 228, 330, 576, 832, 788, 967, 280, 504, 502, 434, 702, 338, 912, 1098, 473, 674, 882, 688, 404, 755, 724, 517}, {707, 389, 1282, 330, 882, 1087, 1242, 658, 1581, 1609, 1389, 280, 96, 1281, 1364, 1458, 1729, 1102, 946, 1462, 186, 1773, 339, 555, 445, 1306, 495, 807, 645, 289, 688, 1324, 776, 1543, 1608, 528, 1136, 769, 1754, 903, 1432, 1065, 1382, 435, 1592, 552, 227, 1553, 179, 850, 897, 851, 701, 1395, 999, 0, 1138, 662, 1674, 770, 736, 424, 358, 1397, 257, 886, 1348, 925, 565, 999, 1016, 86, 100, 1317, 588, 430, 1497, 1248, 555, 620, 1326}, {847, 890, 675, 894, 258, 408, 945, 721, 1016, 839, 630, 866, 1056, 417, 840, 688, 959, 278, 266, 893, 954, 909, 801, 591, 714, 652, 842, 349, 511, 1319, 939, 839, 840, 679, 997, 914, 183, 547, 890, 486, 568, 631, 730, 721, 978, 766, 1050, 1038, 973, 562, 640, 305, 560, 531, 155, 1140, 0, 476, 810, 370, 485, 721, 972, 786, 1122, 372, 397, 588, 589, 742, 382, 1052, 1238, 366, 829, 1037, 633, 297, 895, 864, 462}, {422, 412, 703, 618, 220, 439, 810, 656, 1022, 983, 763, 467, 657, 629, 805, 832, 1103, 440, 284, 899, 476, 1121, 323, 248, 438, 680, 403, 298, 356, 951, 500, 755, 491, 891, 1025, 638, 474, 194, 1102, 324, 780, 496, 758, 243, 1009, 327, 572, 1044, 574, 273, 320, 314, 497, 743, 337, 662, 478, 0, 1020, 108, 422, 379, 496, 814, 790, 224, 686, 348, 378, 496, 364, 576, 762, 655, 663, 761, 843, 586, 458, 427, 672}, {1079, 1329, 585, 1538, 802, 584, 848, 1431, 630, 377, 378, 1443, 1633, 393, 726, 374, 187, 626, 745, 661, 1488, 140, 1337, 1168, 1358, 456, 1242, 1059, 1221, 1928, 1270, 725, 1072, 131, 506, 1558, 638, 905, 121, 771, 242, 794, 485, 1239, 509, 1166, 1567, 728, 1550, 862, 934, 1015, 1270, 279, 865, 1674, 810, 1022, 0, 914, 1195, 1301, 1374, 593, 1768, 802, 461, 812, 1259, 907, 662, 1588, 1734, 548, 1539, 1683, 307, 527, 1297, 1166, 348}, {491, 520, 643, 675, 114, 379, 871, 632, 984, 923, 703, 575, 765, 523, 808, 772, 1043, 334, 178, 861, 584, 1015, 431, 305, 495, 620, 472, 260, 372, 1059, 569, 765, 560, 785, 965, 695, 368, 263, 996, 317, 674, 557, 698, 351, 949, 396, 680, 1006, 682, 337, 389, 216, 471, 637, 229, 770, 372, 108, 916, 0, 396, 436, 604, 754, 898, 205, 580, 412, 394, 565, 304, 684, 870, 549, 720, 818, 737, 480, 527, 496, 566}, {844, 783, 1007, 476, 457, 743, 1232, 236, 1348, 1224, 1015, 473, 642, 802, 1172, 1073, 1344, 658, 502, 1225, 614, 1294, 500, 233, 296, 984, 825, 136, 100, 901, 922, 1129, 913, 1064, 1329, 435, 620, 616, 1275, 713, 953, 918, 1062, 596, 1313, 749, 710, 1370, 559, 695, 742, 180, 75, 916, 330, 738, 485, 422, 1195, 396, 0, 364, 790, 1118, 704, 601, 834, 770, 178, 918, 668, 667, 836, 803, 344, 569, 1018, 734, 880, 849, 847}, {628, 419, 1079, 423, 497, 815, 1163, 461, 1396, 1328, 1119, 144, 334, 906, 1179, 1177, 1448, 745, 589, 1273, 277, 1398, 136, 131, 243, 1056, 476, 426, 264, 634, 609, 1129, 697, 1168, 1401, 443, 751, 566, 1379, 700, 1057, 870, 1134, 232, 1385, 456, 373, 1418, 251, 647, 694, 456, 439, 1020, 577, 424, 722, 379, 1299, 436, 364, 0, 443, 1190, 467, 603, 967, 722, 260, 870, 740, 338, 524, 936, 468, 566, 1124, 867, 536, 541, 953}, {349, 112, 924, 617, 716, 792, 884, 720, 1223, 1252, 1094, 317, 383, 986, 1006, 1163, 1434, 821, 755, 1104, 176, 1478, 319, 574, 494, 1011, 137, 794, 697, 549, 330, 966, 418, 1248, 1250, 697, 927, 474, 1459, 608, 1137, 707, 1024, 271, 1234, 213, 188, 1195, 428, 555, 556, 810, 753, 1100, 833, 358, 974, 496, 1379, 604, 790, 443, 0, 1039, 544, 666, 1056, 616, 619, 641, 716, 272, 360, 1073, 727, 717, 1197, 1005, 197, 262, 1026}, {690, 1025, 115, 1429, 708, 367, 294, 1354, 273, 223, 251, 1210, 1400, 459, 172, 308, 421, 508, 616, 150, 1215, 629, 1068, 1059, 1249, 217, 902, 982, 1126, 1588, 881, 171, 680, 493, 211, 1449, 614, 636, 646, 538, 382, 338, 139, 970, 195, 882, 1227, 295, 1317, 555, 574, 938, 1193, 345, 788, 1397, 786, 814, 600, 754, 1118, 1190, 1039, 0, 1533, 590, 527, 480, 1148, 451, 450, 1311, 1399, 614, 1462, 1572, 372, 558, 936, 777, 414}, {893, 575, 1418, 228, 964, 1215, 1428, 564, 1727, 1737, 1517, 327, 161, 1373, 1510, 1586, 1857, 1212, 1056, 1604, 368, 1865, 467, 598, 411, 1434, 681, 773, 611, 197, 874, 1460, 962, 1635, 1744, 363, 1218, 897, 1846, 1031, 1524, 1201, 1512, 563, 1728, 738, 446, 1739, 216, 978, 1025, 817, 667, 1487, 967, 257, 1122, 790, 1766, 898, 704, 467, 544, 1533, 0, 1014, 1434, 1053, 533, 1185, 1144, 296, 357, 1403, 448, 220, 1591, 1334, 741, 806, 1420}, {489, 621, 479, 842, 200, 215, 684, 837, 820, 759, 539, 691, 881, 409, 644, 608, 879, 244, 108, 697, 700, 901, 547, 472, 662, 456, 534, 465, 577, 1175, 631, 600, 482, 671, 801, 862, 301, 197, 882, 112, 560, 370, 534, 467, 785, 458, 796, 842, 798, 203, 285, 421, 676, 523, 280, 886, 374, 224, 802, 205, 601, 603, 671, 590, 1014, 0, 484, 222, 599, 433, 140, 800, 986, 484, 887, 985, 625, 415, 589, 558, 454}, {765, 1011, 488, 1204, 468, 266, 751, 1070, 784, 490, 281, 1109, 1299, 157, 629, 339, 610, 293, 411, 673, 1164, 560, 1011, 834, 1024, 359, 924, 698, 860, 1599, 956, 628, 758, 330, 664, 1224, 214, 587, 541, 453, 219, 531, 388, 921, 629, 848, 1249, 818, 1216, 544, 620, 654, 909, 182, 504, 1350, 397, 688, 461, 582, 834, 965, 1061, 527, 1432, 484, 0, 498, 925, 642, 344, 1262, 1416, 87, 1178, 1349, 284, 100, 979, 852, 113}, {267, 580, 365, 966, 422, 225, 462, 1004, 674, 693, 526, 730, 920, 423, 457, 595, 866, 310, 330, 551, 739, 911, 588, 596, 786, 443, 479, 646, 704, 1165, 458, 407, 260, 681, 691, 986, 416, 156, 892, 110, 570, 148, 465, 490, 675, 417, 804, 696, 837, 75, 122, 628, 845, 533, 502, 925, 588, 348, 812, 412, 770, 722, 616, 480, 1053, 222, 498, 0, 726, 211, 210, 839, 976, 515, 1011, 1109, 635, 447, 513, 354, 468}, {800, 650, 1037, 305, 455, 773, 1188, 343, 1378, 1286, 1077, 302, 471, 864, 1183, 1135, 1406, 703, 547, 1255, 443, 1356, 396, 155, 125, 1014, 736, 240, 78, 730, 869, 1133, 869, 1126, 1359, 325, 709, 572, 1337, 702, 1015, 874, 1092, 492, 1343, 705, 539, 1400, 388, 651, 698, 284, 253, 978, 434, 567, 589, 378, 1257, 394, 178, 260, 619, 1148, 533, 599, 923, 726, 0, 874, 698, 496, 665, 894, 350, 448, 1082, 825, 796, 801, 911}, {292, 627, 336, 1114, 615, 369, 374, 1152, 641, 664, 534, 878, 1024, 567, 419, 603, 862, 464, 530, 518, 817, 1006, 736, 744, 934, 451, 504, 794, 852, 1190, 483, 368, 235, 776, 662, 1134, 570, 304, 987, 321, 665, 119, 436, 638, 646, 484, 829, 660, 985, 258, 176, 781, 993, 628, 702, 999, 742, 496, 907, 565, 918, 870, 641, 451, 1185, 433, 642, 211, 874, 0, 364, 913, 1001, 659, 1159, 1257, 660, 591, 538, 379, 612}, {477, 671, 339, 979, 258, 75, 567, 904, 680, 619, 399, 821, 1011, 269, 504, 468, 739, 104, 166, 557, 830, 761, 679, 609, 799, 316, 584, 532, 676, 1270, 668, 461, 470, 531, 661, 999, 210, 247, 742, 113, 420, 253, 394, 581, 645, 508, 909, 702, 928, 204, 286, 488, 743, 383, 338, 1016, 382, 364, 662, 304, 668, 740, 721, 450, 1144, 140, 344, 210, 698, 364, 0, 930, 1076, 361, 1012, 1122, 485, 293, 639, 564, 314}, {621, 303, 1196, 369, 796, 1001, 1156, 597, 1495, 1523, 1303, 194, 135, 1195, 1278, 1372, 1643, 1016, 860, 1376, 100, 1687, 253, 469, 371, 1220, 409, 736, 574, 375, 602, 1238, 690, 1457, 1522, 567, 1050, 683, 1668, 817, 1346, 979, 1296, 349, 1506, 466, 150, 1467, 218, 764, 811, 780, 630, 1309, 913, 86, 1054, 576, 1588, 684, 667, 338, 272, 1311, 296, 800, 1264, 839, 496, 913, 930, 0, 186, 1231, 604, 469, 1411, 1162, 469, 534, 1240}, {709, 471, 1284, 430, 982, 1152, 1244, 758, 1583, 1612, 1454, 380, 196, 1346, 1366, 1523, 1794, 1181, 1046, 1464, 286, 1838, 439, 655, 545, 1371, 497, 907, 745, 189, 690, 1326, 778, 1608, 1610, 628, 1236, 834, 1819, 968, 1497, 1067, 1384, 535, 1594, 573, 197, 1555, 279, 915, 916, 951, 801, 1460, 1099, 100, 1240, 762, 1739, 870, 838, 524, 360, 1399, 357, 986, 1421, 976, 667, 1001, 1081, 186, 0, 1417, 688, 530, 1557, 1348, 557, 622, 1386}, {782, 1028, 515, 1173, 437, 283, 802, 1039, 856, 577, 368, 1078, 1268, 174, 680, 426, 697, 282, 380, 733, 1133, 647, 980, 803, 993, 446, 941, 667, 829, 1568, 973, 679, 775, 417, 751, 1193, 183, 604, 628, 470, 306, 548, 475, 900, 716, 865, 1229, 878, 1185, 561, 637, 623, 878, 269, 473, 1319, 366, 657, 548, 551, 803, 934, 1078, 614, 1401, 484, 87, 515, 892, 659, 361, 1233, 1419, 0, 1147, 1318, 371, 89, 996, 869, 200}, {1042, 758, 1351, 308, 781, 1087, 1473, 116, 1685, 1568, 1359, 410, 494, 1146, 1468, 1417, 1688, 1002, 846, 1562, 551, 1638, 550, 415, 233, 1328, 864, 480, 428, 648, 1023, 1418, 1111, 1408, 1673, 94, 964, 857, 1619, 987, 1297, 1159, 1406, 646, 1657, 870, 647, 1707, 411, 936, 983, 524, 269, 1260, 674, 590, 829, 663, 1539, 720, 344, 468, 727, 1462, 451, 887, 1178, 1011, 350, 1159, 1012, 604, 690, 1147, 0, 228, 1362, 1078, 924, 955, 1191}, {1069, 751, 1429, 143, 847, 1165, 1539, 341, 1751, 1678, 1469, 471, 337, 1256, 1534, 1527, 1798, 1095, 939, 1628, 544, 1748, 611, 481, 294, 1406, 857, 656, 494, 420, 1050, 1484, 1138, 1518, 1751, 140, 1101, 923, 1729, 1053, 1407, 1225, 1484, 707, 1735, 914, 622, 1773, 388, 1002, 1049, 700, 494, 1370, 850, 433, 1005, 729, 1649, 786, 569, 534, 720, 1540, 223, 953, 1315, 1077, 416, 1225, 1090, 472, 533, 1284, 228, 0, 1506, 1249, 914, 979, 1335}, {899, 1152, 338, 1361, 625, 407, 601, 1254, 510, 216, 126, 1266, 1456, 216, 479, 69, 336, 449, 568, 501, 1311, 406, 1160, 991, 1181, 209, 1065, 882, 1044, 1751, 1090, 478, 889, 176, 390, 1381, 461, 728, 387, 594, 65, 547, 238, 1062, 355, 989, 1390, 608, 1373, 685, 757, 838, 1093, 102, 688, 1497, 633, 845, 307, 739, 1018, 1122, 1202, 375, 1589, 625, 284, 635, 1080, 660, 485, 1411, 1562, 371, 1362, 1472, 0, 350, 1120, 987, 171}, {714, 960, 447, 1104, 368, 215, 734, 970, 788, 556, 347, 1009, 1199, 134, 612, 405, 676, 193, 311, 665, 1064, 626, 911, 734, 924, 424, 873, 598, 760, 1499, 905, 611, 707, 396, 730, 1124, 114, 536, 607, 402, 285, 480, 454, 831, 695, 797, 1160, 810, 1116, 493, 569, 554, 809, 248, 404, 1250, 297, 588, 527, 482, 734, 865, 1010, 558, 1332, 415, 100, 447, 823, 591, 293, 1164, 1350, 89, 1078, 1215, 350, 0, 928, 801, 179}, {246, 210, 821, 814, 644, 715, 781, 917, 1120, 1149, 1017, 514, 580, 909, 903, 1086, 1347, 744, 678, 1001, 373, 1401, 402, 667, 691, 934, 64, 761, 800, 746, 145, 863, 315, 1171, 1147, 894, 850, 397, 1382, 531, 1060, 604, 921, 304, 1131, 136, 385, 1092, 625, 478, 453, 748, 950, 1023, 761, 555, 902, 463, 1302, 532, 885, 536, 197, 936, 741, 594, 984, 513, 796, 538, 644, 469, 557, 1001, 924, 917, 1125, 933, 0, 159, 949}, {87, 248, 662, 879, 613, 579, 622, 948, 961, 990, 860, 549, 645, 777, 744, 929, 1188, 664, 647, 842, 438, 1265, 407, 672, 722, 777, 125, 730, 788, 811, 129, 704, 156, 1035, 988, 925, 770, 366, 1246, 464, 924, 445, 762, 309, 972, 105, 450, 933, 656, 376, 294, 717, 929, 887, 730, 620, 871, 432, 1166, 501, 854, 541, 262, 777, 806, 563, 852, 354, 801, 379, 564, 534, 622, 869, 955, 982, 986, 801, 159, 0, 822}, {735, 981, 375, 1190, 454, 236, 638, 1083, 671, 377, 168, 1095, 1285, 45, 516, 226, 497, 278, 397, 560, 1140, 447, 989, 820, 1010, 246, 894, 711, 873, 1580, 926, 515, 728, 217, 551, 1210, 290, 557, 428, 423, 106, 501, 275, 891, 516, 818, 1219, 705, 1202, 514, 590, 667, 922, 69, 517, 1326, 462, 674, 348, 568, 847, 951, 1031, 414, 1418, 454, 113, 468, 909, 612, 314, 1240, 1391, 200, 1191, 1301, 171, 179, 954, 822, 0}};

    private TurkishNetwork() {
    }
}